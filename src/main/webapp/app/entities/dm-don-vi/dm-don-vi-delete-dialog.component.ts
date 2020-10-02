import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDmDonVi } from 'app/shared/model/dm-don-vi.model';
import { DmDonViService } from './dm-don-vi.service';

@Component({
  templateUrl: './dm-don-vi-delete-dialog.component.html',
})
export class DmDonViDeleteDialogComponent {
  dmDonVi?: IDmDonVi;

  constructor(protected dmDonViService: DmDonViService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: string): void {
    this.dmDonViService.delete(id).subscribe(() => {
      this.eventManager.broadcast('dmDonViListModification');
      this.activeModal.close();
    });
  }
}
