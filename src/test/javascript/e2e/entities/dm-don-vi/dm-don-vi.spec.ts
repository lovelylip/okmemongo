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

    await promise.all([dmDonViUpdatePage.setMaInput('ma')]);

    expect(await dmDonViUpdatePage.getMaInput()).to.eq('ma', 'Expected Ma value to be equals to ma');

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
