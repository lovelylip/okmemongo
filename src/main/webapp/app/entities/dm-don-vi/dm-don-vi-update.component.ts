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
