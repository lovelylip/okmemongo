import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { DmCqbhComponentsPage, DmCqbhDeleteDialog, DmCqbhUpdatePage } from './dm-cqbh.page-object';

const expect = chai.expect;

describe('DmCqbh e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let dmCqbhComponentsPage: DmCqbhComponentsPage;
  let dmCqbhUpdatePage: DmCqbhUpdatePage;
  let dmCqbhDeleteDialog: DmCqbhDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load DmCqbhs', async () => {
    await navBarPage.goToEntity('dm-cqbh');
    dmCqbhComponentsPage = new DmCqbhComponentsPage();
    await browser.wait(ec.visibilityOf(dmCqbhComponentsPage.title), 5000);
    expect(await dmCqbhComponentsPage.getTitle()).to.eq('okmeApp.dmCqbh.home.title');
    await browser.wait(ec.or(ec.visibilityOf(dmCqbhComponentsPage.entities), ec.visibilityOf(dmCqbhComponentsPage.noResult)), 1000);
  });

  it('should load create DmCqbh page', async () => {
    await dmCqbhComponentsPage.clickOnCreateButton();
    dmCqbhUpdatePage = new DmCqbhUpdatePage();
    expect(await dmCqbhUpdatePage.getPageTitle()).to.eq('okmeApp.dmCqbh.home.createOrEditLabel');
    await dmCqbhUpdatePage.cancel();
  });

  it('should create and save DmCqbhs', async () => {
    const nbButtonsBeforeCreate = await dmCqbhComponentsPage.countDeleteButtons();

    await dmCqbhComponentsPage.clickOnCreateButton();

    await promise.all([
      dmCqbhUpdatePage.setMaInput('ma'),
      dmCqbhUpdatePage.setTenInput('ten'),
      dmCqbhUpdatePage.setDiaChiInput('diaChi'),
      dmCqbhUpdatePage.setMaXaInput('maXa'),
      dmCqbhUpdatePage.setMaHuyenInput('maHuyen'),
      dmCqbhUpdatePage.setMaTinhInput('maTinh'),
      dmCqbhUpdatePage.setEmailAccInput('emailAcc'),
      dmCqbhUpdatePage.setPhoneNumberInput('phoneNumber'),
      dmCqbhUpdatePage.setStatusInput('status'),
      dmCqbhUpdatePage.setCreateDateInput('2000-12-31'),
      dmCqbhUpdatePage.setActiveDateInput('2000-12-31'),
      dmCqbhUpdatePage.setInactiveDateInput('2000-12-31'),
      dmCqbhUpdatePage.setMaCqbhChaInput('maCqbhCha'),
      dmCqbhUpdatePage.setNguoiKyInput('nguoiKy'),
      dmCqbhUpdatePage.setChucDanhInput('chucDanh'),
      dmCqbhUpdatePage.setTenNoiKyInput('tenNoiKy'),
      dmCqbhUpdatePage.setIsActiveInput('isActive'),
      dmCqbhUpdatePage.setPathInput('path'),
      dmCqbhUpdatePage.setNgayKhoaInput('5'),
      dmCqbhUpdatePage.setNgayTempInput('ngayTemp'),
    ]);

    expect(await dmCqbhUpdatePage.getMaInput()).to.eq('ma', 'Expected Ma value to be equals to ma');
    expect(await dmCqbhUpdatePage.getTenInput()).to.eq('ten', 'Expected Ten value to be equals to ten');
    expect(await dmCqbhUpdatePage.getDiaChiInput()).to.eq('diaChi', 'Expected DiaChi value to be equals to diaChi');
    expect(await dmCqbhUpdatePage.getMaXaInput()).to.eq('maXa', 'Expected MaXa value to be equals to maXa');
    expect(await dmCqbhUpdatePage.getMaHuyenInput()).to.eq('maHuyen', 'Expected MaHuyen value to be equals to maHuyen');
    expect(await dmCqbhUpdatePage.getMaTinhInput()).to.eq('maTinh', 'Expected MaTinh value to be equals to maTinh');
    expect(await dmCqbhUpdatePage.getEmailAccInput()).to.eq('emailAcc', 'Expected EmailAcc value to be equals to emailAcc');
    expect(await dmCqbhUpdatePage.getPhoneNumberInput()).to.eq('phoneNumber', 'Expected PhoneNumber value to be equals to phoneNumber');
    expect(await dmCqbhUpdatePage.getStatusInput()).to.eq('status', 'Expected Status value to be equals to status');
    expect(await dmCqbhUpdatePage.getCreateDateInput()).to.eq('2000-12-31', 'Expected createDate value to be equals to 2000-12-31');
    expect(await dmCqbhUpdatePage.getActiveDateInput()).to.eq('2000-12-31', 'Expected activeDate value to be equals to 2000-12-31');
    expect(await dmCqbhUpdatePage.getInactiveDateInput()).to.eq('2000-12-31', 'Expected inactiveDate value to be equals to 2000-12-31');
    expect(await dmCqbhUpdatePage.getMaCqbhChaInput()).to.eq('maCqbhCha', 'Expected MaCqbhCha value to be equals to maCqbhCha');
    expect(await dmCqbhUpdatePage.getNguoiKyInput()).to.eq('nguoiKy', 'Expected NguoiKy value to be equals to nguoiKy');
    expect(await dmCqbhUpdatePage.getChucDanhInput()).to.eq('chucDanh', 'Expected ChucDanh value to be equals to chucDanh');
    expect(await dmCqbhUpdatePage.getTenNoiKyInput()).to.eq('tenNoiKy', 'Expected TenNoiKy value to be equals to tenNoiKy');
    expect(await dmCqbhUpdatePage.getIsActiveInput()).to.eq('isActive', 'Expected IsActive value to be equals to isActive');
    expect(await dmCqbhUpdatePage.getPathInput()).to.eq('path', 'Expected Path value to be equals to path');
    expect(await dmCqbhUpdatePage.getNgayKhoaInput()).to.eq('5', 'Expected ngayKhoa value to be equals to 5');
    expect(await dmCqbhUpdatePage.getNgayTempInput()).to.eq('ngayTemp', 'Expected NgayTemp value to be equals to ngayTemp');

    await dmCqbhUpdatePage.save();
    expect(await dmCqbhUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await dmCqbhComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last DmCqbh', async () => {
    const nbButtonsBeforeDelete = await dmCqbhComponentsPage.countDeleteButtons();
    await dmCqbhComponentsPage.clickOnLastDeleteButton();

    dmCqbhDeleteDialog = new DmCqbhDeleteDialog();
    expect(await dmCqbhDeleteDialog.getDialogTitle()).to.eq('okmeApp.dmCqbh.delete.question');
    await dmCqbhDeleteDialog.clickOnConfirmButton();

    expect(await dmCqbhComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
