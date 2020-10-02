import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDmCqbh } from 'app/shared/model/dm-cqbh.model';

@Component({
  selector: 'jhi-dm-cqbh-detail',
  templateUrl: './dm-cqbh-detail.component.html',
})
export class DmCqbhDetailComponent implements OnInit {
  dmCqbh: IDmCqbh | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dmCqbh }) => (this.dmCqbh = dmCqbh));
  }

  previousState(): void {
    window.history.back();
  }
}
