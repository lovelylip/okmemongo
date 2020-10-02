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

    await promise.all([dmCqbhUpdatePage.setMaInput('ma')]);

    expect(await dmCqbhUpdatePage.getMaInput()).to.eq('ma', 'Expected Ma value to be equals to ma');

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
