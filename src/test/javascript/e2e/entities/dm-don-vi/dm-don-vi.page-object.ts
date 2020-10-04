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
  tenInput = element(by.id('field_ten'));
  tongLdInput = element(by.id('field_tongLd'));
  tongLuongInput = element(by.id('field_tongLuong'));
  loaiDvInput = element(by.id('field_loaiDv'));
  diachiInput = element(by.id('field_diachi'));
  dienthoaiInput = element(by.id('field_dienthoai'));
  faxInput = element(by.id('field_fax'));
  soTaiKhoanInput = element(by.id('field_soTaiKhoan'));
  nganHangInput = element(by.id('field_nganHang'));
  maCqbhInput = element(by.id('field_maCqbh'));
  maTinhInput = element(by.id('field_maTinh'));
  maHuyenInput = element(by.id('field_maHuyen'));
  soDkkdInput = element(by.id('field_soDkkd'));
  maStInput = element(by.id('field_maSt'));
  nguoiLhInput = element(by.id('field_nguoiLh'));
  maDvikcbInput = element(by.id('field_maDvikcb'));
  maKhoikcbInput = element(by.id('field_maKhoikcb'));

  async getPageTitle(): Promise<string> {
    return this.pageTitle.getAttribute('jhiTranslate');
  }

  async setMaInput(ma: string): Promise<void> {
    await this.maInput.sendKeys(ma);
  }

  async getMaInput(): Promise<string> {
    return await this.maInput.getAttribute('value');
  }

  async setTenInput(ten: string): Promise<void> {
    await this.tenInput.sendKeys(ten);
  }

  async getTenInput(): Promise<string> {
    return await this.tenInput.getAttribute('value');
  }

  async setTongLdInput(tongLd: string): Promise<void> {
    await this.tongLdInput.sendKeys(tongLd);
  }

  async getTongLdInput(): Promise<string> {
    return await this.tongLdInput.getAttribute('value');
  }

  async setTongLuongInput(tongLuong: string): Promise<void> {
    await this.tongLuongInput.sendKeys(tongLuong);
  }

  async getTongLuongInput(): Promise<string> {
    return await this.tongLuongInput.getAttribute('value');
  }

  async setLoaiDvInput(loaiDv: string): Promise<void> {
    await this.loaiDvInput.sendKeys(loaiDv);
  }

  async getLoaiDvInput(): Promise<string> {
    return await this.loaiDvInput.getAttribute('value');
  }

  async setDiachiInput(diachi: string): Promise<void> {
    await this.diachiInput.sendKeys(diachi);
  }

  async getDiachiInput(): Promise<string> {
    return await this.diachiInput.getAttribute('value');
  }

  async setDienthoaiInput(dienthoai: string): Promise<void> {
    await this.dienthoaiInput.sendKeys(dienthoai);
  }

  async getDienthoaiInput(): Promise<string> {
    return await this.dienthoaiInput.getAttribute('value');
  }

  async setFaxInput(fax: string): Promise<void> {
    await this.faxInput.sendKeys(fax);
  }

  async getFaxInput(): Promise<string> {
    return await this.faxInput.getAttribute('value');
  }

  async setSoTaiKhoanInput(soTaiKhoan: string): Promise<void> {
    await this.soTaiKhoanInput.sendKeys(soTaiKhoan);
  }

  async getSoTaiKhoanInput(): Promise<string> {
    return await this.soTaiKhoanInput.getAttribute('value');
  }

  async setNganHangInput(nganHang: string): Promise<void> {
    await this.nganHangInput.sendKeys(nganHang);
  }

  async getNganHangInput(): Promise<string> {
    return await this.nganHangInput.getAttribute('value');
  }

  async setMaCqbhInput(maCqbh: string): Promise<void> {
    await this.maCqbhInput.sendKeys(maCqbh);
  }

  async getMaCqbhInput(): Promise<string> {
    return await this.maCqbhInput.getAttribute('value');
  }

  async setMaTinhInput(maTinh: string): Promise<void> {
    await this.maTinhInput.sendKeys(maTinh);
  }

  async getMaTinhInput(): Promise<string> {
    return await this.maTinhInput.getAttribute('value');
  }

  async setMaHuyenInput(maHuyen: string): Promise<void> {
    await this.maHuyenInput.sendKeys(maHuyen);
  }

  async getMaHuyenInput(): Promise<string> {
    return await this.maHuyenInput.getAttribute('value');
  }

  async setSoDkkdInput(soDkkd: string): Promise<void> {
    await this.soDkkdInput.sendKeys(soDkkd);
  }

  async getSoDkkdInput(): Promise<string> {
    return await this.soDkkdInput.getAttribute('value');
  }

  async setMaStInput(maSt: string): Promise<void> {
    await this.maStInput.sendKeys(maSt);
  }

  async getMaStInput(): Promise<string> {
    return await this.maStInput.getAttribute('value');
  }

  async setNguoiLhInput(nguoiLh: string): Promise<void> {
    await this.nguoiLhInput.sendKeys(nguoiLh);
  }

  async getNguoiLhInput(): Promise<string> {
    return await this.nguoiLhInput.getAttribute('value');
  }

  async setMaDvikcbInput(maDvikcb: string): Promise<void> {
    await this.maDvikcbInput.sendKeys(maDvikcb);
  }

  async getMaDvikcbInput(): Promise<string> {
    return await this.maDvikcbInput.getAttribute('value');
  }

  async setMaKhoikcbInput(maKhoikcb: string): Promise<void> {
    await this.maKhoikcbInput.sendKeys(maKhoikcb);
  }

  async getMaKhoikcbInput(): Promise<string> {
    return await this.maKhoikcbInput.getAttribute('value');
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
