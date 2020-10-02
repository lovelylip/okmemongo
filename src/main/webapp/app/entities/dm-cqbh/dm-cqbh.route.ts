import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDmCqbh, DmCqbh } from 'app/shared/model/dm-cqbh.model';
import { DmCqbhService } from './dm-cqbh.service';
import { DmCqbhComponent } from './dm-cqbh.component';
import { DmCqbhDetailComponent } from './dm-cqbh-detail.component';
import { DmCqbhUpdateComponent } from './dm-cqbh-update.component';

@Injectable({ providedIn: 'root' })
export class DmCqbhResolve implements Resolve<IDmCqbh> {
  constructor(private service: DmCqbhService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDmCqbh> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((dmCqbh: HttpResponse<DmCqbh>) => {
          if (dmCqbh.body) {
            return of(dmCqbh.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DmCqbh());
  }
}

export const dmCqbhRoute: Routes = [
  {
    path: '',
    component: DmCqbhComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'okmeApp.dmCqbh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DmCqbhDetailComponent,
    resolve: {
      dmCqbh: DmCqbhResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'okmeApp.dmCqbh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DmCqbhUpdateComponent,
    resolve: {
      dmCqbh: DmCqbhResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'okmeApp.dmCqbh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DmCqbhUpdateComponent,
    resolve: {
      dmCqbh: DmCqbhResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'okmeApp.dmCqbh.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
