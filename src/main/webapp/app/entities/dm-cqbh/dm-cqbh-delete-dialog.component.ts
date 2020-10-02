import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDmCqbh } from 'app/shared/model/dm-cqbh.model';
import { DmCqbhService } from './dm-cqbh.service';

@Component({
  templateUrl: './dm-cqbh-delete-dialog.component.html',
})
export class DmCqbhDeleteDialogComponent {
  dmCqbh?: IDmCqbh;

  constructor(protected dmCqbhService: DmCqbhService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: string): void {
    this.dmCqbhService.delete(id).subscribe(() => {
      this.eventManager.broadcast('dmCqbhListModification');
      this.activeModal.close();
    });
  }
}
