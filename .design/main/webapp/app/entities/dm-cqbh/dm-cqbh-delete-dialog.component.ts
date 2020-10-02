import {ElementSelectionService} from './../../../../../app/element-selection.service';
import {ComponentInspectorService} from './../../../../../app/component-inspector.service';
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

  constructor(public __elementSelectionService:ElementSelectionService, private __componentInspectorService:ComponentInspectorService,
protected dmCqbhService: DmCqbhService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {this.__componentInspectorService.getComp(this);
}

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
