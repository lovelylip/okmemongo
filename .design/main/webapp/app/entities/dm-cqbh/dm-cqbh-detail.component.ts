import {ElementSelectionService} from './../../../../../app/element-selection.service';
import {ComponentInspectorService} from './../../../../../app/component-inspector.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDmCqbh } from 'app/shared/model/dm-cqbh.model';

@Component({
  selector: 'jhi-dm-cqbh-detail',
  templateUrl: './dm-cqbh-detail.component.html',
})
export class DmCqbhDetailComponent implements OnInit {
  dmCqbh: IDmCqbh | null = null;

  constructor(public __elementSelectionService:ElementSelectionService, private __componentInspectorService:ComponentInspectorService,
protected activatedRoute: ActivatedRoute) {this.__componentInspectorService.getComp(this);
}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmCqbh }) => (this.dmCqbh = dmCqbh));
  }

  previousState(): void {
    window.history.back();
  }
}
