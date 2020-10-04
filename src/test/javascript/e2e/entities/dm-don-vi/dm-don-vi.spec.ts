import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { DmDonViComponentsPage, DmDonViDeleteDialog, DmDonViUpdatePage } from './dm-don-vi.page-object';

const expect = chai.expect;

describe('DmDonVi e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let dmDonViComponentsPage: DmDonViComponentsPage;
  let dmDonViUpdatePage: DmDonViUpdatePage;
  let dmDonViDeleteDialog: DmDonViDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load DmDonVis', async () => {
    await navBarPage.goToEntity('dm-don-vi');
    dmDonViComponentsPage = new DmDonViComponentsPage();
    await browser.wait(ec.visibilityOf(dmDonViComponentsPage.title), 5000);
    expect(await dmDonViComponentsPage.getTitle()).to.eq('okmeApp.dmDonVi.home.title');
    await browser.wait(ec.or(ec.visibilityOf(dmDonViComponentsPage.entities), ec.visibilityOf(dmDonViComponentsPage.noResult)), 1000);
  });

  it('should load create DmDonVi page', async () => {
    await dmDonViComponentsPage.clickOnCreateButton();
    dmDonViUpdatePage = new DmDonViUpdatePage();
    expect(await dmDonViUpdatePage.getPageTitle()).to.eq('okmeApp.dmDonVi.home.createOrEditLabel');
    await dmDonViUpdatePage.cancel();
  });

  it('should create and save DmDonVis', async () => {
    const nbButtonsBeforeCreate = await dmDonViComponentsPage.countDeleteButtons();

    await dmDonViComponentsPage.clickOnCreateButton();

    await promise.all([
      dmDonViUpdatePage.setMaInput('ma'),
      dmDonViUpdatePage.setTenInput('ten'),
      dmDonViUpdatePage.setTongLdInput('5'),
      dmDonViUpdatePage.setTongLuongInput('5'),
      dmDonViUpdatePage.setLoaiDvInput('loaiDv'),
      dmDonViUpdatePage.setDiachiInput('diachi'),
      dmDonViUpdatePage.setDienthoaiInput('dienthoai'),
      dmDonViUpdatePage.setFaxInput('fax'),
      dmDonViUpdatePage.setSoTaiKhoanInput('soTaiKhoan'),
      dmDonViUpdatePage.setNganHangInput('nganHang'),
      dmDonViUpdatePage.setMaCqbhInput('maCqbh'),
      dmDonViUpdatePage.setMaTinhInput('maTinh'),
      dmDonViUpdatePage.setMaHuyenInput('maHuyen'),
      dmDonViUpdatePage.setSoDkkdInput('soDkkd'),
      dmDonViUpdatePage.setMaStInput('maSt'),
      dmDonViUpdatePage.setNguoiLhInput('nguoiLh'),
      dmDonViUpdatePage.setMaDvikcbInput('maDvikcb'),
      dmDonViUpdatePage.setMaKhoikcbInput('maKhoikcb'),
    ]);

    expect(await dmDonViUpdatePage.getMaInput()).to.eq('ma', 'Expected Ma value to be equals to ma');
    expect(await dmDonViUpdatePage.getTenInput()).to.eq('ten', 'Expected Ten value to be equals to ten');
    expect(await dmDonViUpdatePage.getTongLdInput()).to.eq('5', 'Expected tongLd value to be equals to 5');
    expect(await dmDonViUpdatePage.getTongLuongInput()).to.eq('5', 'Expected tongLuong value to be equals to 5');
    expect(await dmDonViUpdatePage.getLoaiDvInput()).to.eq('loaiDv', 'Expected LoaiDv value to be equals to loaiDv');
    expect(await dmDonViUpdatePage.getDiachiInput()).to.eq('diachi', 'Expected Diachi value to be equals to diachi');
    expect(await dmDonViUpdatePage.getDienthoaiInput()).to.eq('dienthoai', 'Expected Dienthoai value to be equals to dienthoai');
    expect(await dmDonViUpdatePage.getFaxInput()).to.eq('fax', 'Expected Fax value to be equals to fax');
    expect(await dmDonViUpdatePage.getSoTaiKhoanInput()).to.eq('soTaiKhoan', 'Expected SoTaiKhoan value to be equals to soTaiKhoan');
    expect(await dmDonViUpdatePage.getNganHangInput()).to.eq('nganHang', 'Expected NganHang value to be equals to nganHang');
    expect(await dmDonViUpdatePage.getMaCqbhInput()).to.eq('maCqbh', 'Expected MaCqbh value to be equals to maCqbh');
    expect(await dmDonViUpdatePage.getMaTinhInput()).to.eq('maTinh', 'Expected MaTinh value to be equals to maTinh');
    expect(await dmDonViUpdatePage.getMaHuyenInput()).to.eq('maHuyen', 'Expected MaHuyen value to be equals to maHuyen');
    expect(await dmDonViUpdatePage.getSoDkkdInput()).to.eq('soDkkd', 'Expected SoDkkd value to be equals to soDkkd');
    expect(await dmDonViUpdatePage.getMaStInput()).to.eq('maSt', 'Expected MaSt value to be equals to maSt');
    expect(await dmDonViUpdatePage.getNguoiLhInput()).to.eq('nguoiLh', 'Expected NguoiLh value to be equals to nguoiLh');
    expect(await dmDonViUpdatePage.getMaDvikcbInput()).to.eq('maDvikcb', 'Expected MaDvikcb value to be equals to maDvikcb');
    expect(await dmDonViUpdatePage.getMaKhoikcbInput()).to.eq('maKhoikcb', 'Expected MaKhoikcb value to be equals to maKhoikcb');

    await dmDonViUpdatePage.save();
    expect(await dmDonViUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await dmDonViComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last DmDonVi', async () => {
    const nbButtonsBeforeDelete = await dmDonViComponentsPage.countDeleteButtons();
    await dmDonViComponentsPage.clickOnLastDeleteButton();

    dmDonViDeleteDialog = new DmDonViDeleteDialog();
    expect(await dmDonViDeleteDialog.getDialogTitle()).to.eq('okmeApp.dmDonVi.delete.question');
    await dmDonViDeleteDialog.clickOnConfirmButton();

    expect(await dmDonViComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
