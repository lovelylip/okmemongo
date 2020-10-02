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

  editForm = this.fb.group({
    id: [],
    ma: [null, [Validators.required]],
    ten: [],
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
