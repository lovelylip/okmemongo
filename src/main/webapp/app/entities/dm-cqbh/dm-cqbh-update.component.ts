import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDmCqbh, DmCqbh } from 'app/shared/model/dm-cqbh.model';
import { DmCqbhService } from './dm-cqbh.service';

@Component({
  selector: 'jhi-dm-cqbh-update',
  templateUrl: './dm-cqbh-update.component.html',
})
export class DmCqbhUpdateComponent implements OnInit {
  isSaving = false;
  createDateDp: any;
  activeDateDp: any;
  inactiveDateDp: any;

  editForm = this.fb.group({
    id: [],
    ma: [null, [Validators.required]],
    ten: [],
    diaChi: [],
    maXa: [],
    maHuyen: [],
    maTinh: [],
    emailAcc: [],
    phoneNumber: [],
    status: [],
    createDate: [],
    activeDate: [],
    inactiveDate: [],
    maCqbhCha: [],
    nguoiKy: [],
    chucDanh: [],
    tenNoiKy: [],
    isActive: [],
    path: [],
    ngayKhoa: [],
    ngayTemp: [],
  });

  constructor(protected dmCqbhService: DmCqbhService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmCqbh }) => {
      this.updateForm(dmCqbh);
    });
  }

  updateForm(dmCqbh: IDmCqbh): void {
    this.editForm.patchValue({
      id: dmCqbh.id,
      ma: dmCqbh.ma,
      ten: dmCqbh.ten,
      diaChi: dmCqbh.diaChi,
      maXa: dmCqbh.maXa,
      maHuyen: dmCqbh.maHuyen,
      maTinh: dmCqbh.maTinh,
      emailAcc: dmCqbh.emailAcc,
      phoneNumber: dmCqbh.phoneNumber,
      status: dmCqbh.status,
      createDate: dmCqbh.createDate,
      activeDate: dmCqbh.activeDate,
      inactiveDate: dmCqbh.inactiveDate,
      maCqbhCha: dmCqbh.maCqbhCha,
      nguoiKy: dmCqbh.nguoiKy,
      chucDanh: dmCqbh.chucDanh,
      tenNoiKy: dmCqbh.tenNoiKy,
      isActive: dmCqbh.isActive,
      path: dmCqbh.path,
      ngayKhoa: dmCqbh.ngayKhoa,
      ngayTemp: dmCqbh.ngayTemp,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dmCqbh = this.createFromForm();
    if (dmCqbh.id !== undefined) {
      this.subscribeToSaveResponse(this.dmCqbhService.update(dmCqbh));
    } else {
      this.subscribeToSaveResponse(this.dmCqbhService.create(dmCqbh));
    }
  }

  private createFromForm(): IDmCqbh {
    return {
      ...new DmCqbh(),
      id: this.editForm.get(['id'])!.value,
      ma: this.editForm.get(['ma'])!.value,
      ten: this.editForm.get(['ten'])!.value,
      diaChi: this.editForm.get(['diaChi'])!.value,
      maXa: this.editForm.get(['maXa'])!.value,
      maHuyen: this.editForm.get(['maHuyen'])!.value,
      maTinh: this.editForm.get(['maTinh'])!.value,
      emailAcc: this.editForm.get(['emailAcc'])!.value,
      phoneNumber: this.editForm.get(['phoneNumber'])!.value,
      status: this.editForm.get(['status'])!.value,
      createDate: this.editForm.get(['createDate'])!.value,
      activeDate: this.editForm.get(['activeDate'])!.value,
      inactiveDate: this.editForm.get(['inactiveDate'])!.value,
      maCqbhCha: this.editForm.get(['maCqbhCha'])!.value,
      nguoiKy: this.editForm.get(['nguoiKy'])!.value,
      chucDanh: this.editForm.get(['chucDanh'])!.value,
      tenNoiKy: this.editForm.get(['tenNoiKy'])!.value,
      isActive: this.editForm.get(['isActive'])!.value,
      path: this.editForm.get(['path'])!.value,
      ngayKhoa: this.editForm.get(['ngayKhoa'])!.value,
      ngayTemp: this.editForm.get(['ngayTemp'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDmCqbh>>): void {
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
