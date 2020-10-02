import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDmDonVi, DmDonVi } from 'app/shared/model/dm-don-vi.model';
import { DmDonViService } from './dm-don-vi.service';
import { DmDonViComponent } from './dm-don-vi.component';
import { DmDonViDetailComponent } from './dm-don-vi-detail.component';
import { DmDonViUpdateComponent } from './dm-don-vi-update.component';

@Injectable({ providedIn: 'root' })
export class DmDonViResolve implements Resolve<IDmDonVi> {
  constructor(private service: DmDonViService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDmDonVi> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((dmDonVi: HttpResponse<DmDonVi>) => {
          if (dmDonVi.body) {
            return of(dmDonVi.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DmDonVi());
  }
}

export const dmDonViRoute: Routes = [
  {
    path: '',
    component: DmDonViComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'okmeApp.dmDonVi.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DmDonViDetailComponent,
    resolve: {
      dmDonVi: DmDonViResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'okmeApp.dmDonVi.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: DmDonViUpdateComponent,
    resolve: {
      dmDonVi: DmDonViResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'okmeApp.dmDonVi.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: DmDonViUpdateComponent,
    resolve: {
      dmDonVi: DmDonViResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'okmeApp.dmDonVi.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
