import {ElementSelectionService} from './../../../../../app/element-selection.service';
import {ComponentInspectorService} from './../../../../../app/component-inspector.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProfileService } from './profile.service';

@Component({
  selector: 'jhi-page-ribbon',
  template: `
    <div class="ribbon" *ngIf="ribbonEnv$ | async as ribbonEnv">
      <a href="" jhiTranslate="global.ribbon.{{ ribbonEnv }}">{{ ribbonEnv }}</a>
    </div>
  `,
  styleUrls: ['page-ribbon.scss'],
})
export class PageRibbonComponent implements OnInit {
  constructor(public __elementSelectionService:ElementSelectionService,private __componentInspectorService:ComponentInspectorService) { this.__componentInspectorService.getComp(this); }ribbonEnv$?: Observable<string | undefined>;

  constructor(private profileService: ProfileService) {}

  ngOnInit(): void {
    this.ribbonEnv$ = this.profileService.getProfileInfo().pipe(map(profileInfo => profileInfo.ribbonEnv));
  }
}
