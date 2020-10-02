import {ElementSelectionService} from './../../../../../app/element-selection.service';
import {ComponentInspectorService} from './../../../../../app/component-inspector.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDmDonVi } from 'app/shared/model/dm-don-vi.model';

@Component({
  selector: 'jhi-dm-don-vi-detail',
  templateUrl: './dm-don-vi-detail.component.html',
})
export class DmDonViDetailComponent implements OnInit {
  dmDonVi: IDmDonVi | null = null;

  constructor(public __elementSelectionService:ElementSelectionService, private __componentInspectorService:ComponentInspectorService,
protected activatedRoute: ActivatedRoute) {this.__componentInspectorService.getComp(this);
}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmDonVi }) => (this.dmDonVi = dmDonVi));
  }

  previousState(): void {
    window.history.back();
  }
}
