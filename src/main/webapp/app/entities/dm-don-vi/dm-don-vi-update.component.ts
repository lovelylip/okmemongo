import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDmDonVi, DmDonVi } from 'app/shared/model/dm-don-vi.model';
import { DmDonViService } from './dm-don-vi.service';

@Component({
  selector: 'jhi-dm-don-vi-update',
  templateUrl: './dm-don-vi-update.component.html',
})
export class DmDonViUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    ma: [null, [Validators.required, Validators.minLength(0), Validators.maxLength(20)]],
    ten: [],
    tongLd: [],
    tongLuong: [],
    loaiDv: [],
    diachi: [],
    dienthoai: [],
    fax: [],
    soTaiKhoan: [],
    nganHang: [],
    maCqbh: [],
    maTinh: [],
    maHuyen: [],
    soDkkd: [],
    maSt: [],
    nguoiLh: [],
    maDvikcb: [],
    maKhoikcb: [],
  });

  constructor(protected dmDonViService: DmDonViService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmDonVi }) => {
      this.updateForm(dmDonVi);
    });
  }

  updateForm(dmDonVi: IDmDonVi): void {
    this.editForm.patchValue({
      id: dmDonVi.id,
      ma: dmDonVi.ma,
      ten: dmDonVi.ten,
      tongLd: dmDonVi.tongLd,
      tongLuong: dmDonVi.tongLuong,
      loaiDv: dmDonVi.loaiDv,
      diachi: dmDonVi.diachi,
      dienthoai: dmDonVi.dienthoai,
      fax: dmDonVi.fax,
      soTaiKhoan: dmDonVi.soTaiKhoan,
      nganHang: dmDonVi.nganHang,
      maCqbh: dmDonVi.maCqbh,
      maTinh: dmDonVi.maTinh,
      maHuyen: dmDonVi.maHuyen,
      soDkkd: dmDonVi.soDkkd,
      maSt: dmDonVi.maSt,
      nguoiLh: dmDonVi.nguoiLh,
      maDvikcb: dmDonVi.maDvikcb,
      maKhoikcb: dmDonVi.maKhoikcb,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dmDonVi = this.createFromForm();
    if (dmDonVi.id !== undefined) {
      this.subscribeToSaveResponse(this.dmDonViService.update(dmDonVi));
    } else {
      this.subscribeToSaveResponse(this.dmDonViService.create(dmDonVi));
    }
  }

  private createFromForm(): IDmDonVi {
    return {
      ...new DmDonVi(),
      id: this.editForm.get(['id'])!.value,
      ma: this.editForm.get(['ma'])!.value,
      ten: this.editForm.get(['ten'])!.value,
      tongLd: this.editForm.get(['tongLd'])!.value,
      tongLuong: this.editForm.get(['tongLuong'])!.value,
      loaiDv: this.editForm.get(['loaiDv'])!.value,
      diachi: this.editForm.get(['diachi'])!.value,
      dienthoai: this.editForm.get(['dienthoai'])!.value,
      fax: this.editForm.get(['fax'])!.value,
      soTaiKhoan: this.editForm.get(['soTaiKhoan'])!.value,
      nganHang: this.editForm.get(['nganHang'])!.value,
      maCqbh: this.editForm.get(['maCqbh'])!.value,
      maTinh: this.editForm.get(['maTinh'])!.value,
      maHuyen: this.editForm.get(['maHuyen'])!.value,
      soDkkd: this.editForm.get(['soDkkd'])!.value,
      maSt: this.editForm.get(['maSt'])!.value,
      nguoiLh: this.editForm.get(['nguoiLh'])!.value,
      maDvikcb: this.editForm.get(['maDvikcb'])!.value,
      maKhoikcb: this.editForm.get(['maKhoikcb'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDmDonVi>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
