import { element, by, ElementFinder } from 'protractor';

export class DmDonViComponentsPage {
  createButton = element(by.id('jh-create-entity'));
  deleteButtons = element.all(by.css('jhi-dm-don-vi div table .btn-danger'));
  title = element.all(by.css('jhi-dm-don-vi div h2#page-heading span')).first();
  noResult = element(by.id('no-result'));
  entities = element(by.id('entities'));

  async clickOnCreateButton(): Promise<void> {
    await this.createButton.click();
  }

  async clickOnLastDeleteButton(): Promise<void> {
    await this.deleteButtons.last().click();
  }

  async countDeleteButtons(): Promise<number> {
    return this.deleteButtons.count();
  }

  async getTitle(): Promise<string> {
    return this.title.getAttribute('jhiTranslate');
  }
}

export class DmDonViUpdatePage {
  pageTitle = element(by.id('jhi-dm-don-vi-heading'));
  saveButton = element(by.id('save-entity'));
  cancelButton = element(by.id('cancel-save'));

  maInput = element(by.id('field_ma'));

  async getPageTitle(): Promise<string> {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setMaInput(ma: string): Promise<void> {
    await this.maInput.sendKeys(ma);
  }

  async getMaInput(): Promise<string> {
    return await this.maInput.getAttribute('value');
  }

  async save(): Promise<void> {
    await this.saveButton.click();
  }

  async cancel(): Promise<void> {
    await this.cancelButton.click();
  }

  getSaveButton(): ElementFinder {
    return this.saveButton;
  }
}

export class DmDonViDeleteDialog {
  private dialogTitle = element(by.id('jhi-delete-dmDonVi-heading'));
  private confirmButton = element(by.id('jhi-confirm-delete-dmDonVi'));

  async getDialogTitle(): Promise<string> {
    return this.dialogTitle.getAttribute('jhiTranslate');
  }

  async clickOnConfirmButton(): Promise<void> {
    await this.confirmButton.click();
  }
}
