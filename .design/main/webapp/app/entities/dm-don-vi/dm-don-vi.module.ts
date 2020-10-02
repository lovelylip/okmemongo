import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OkmeSharedModule } from 'app/shared/shared.module';
import { DmDonViComponent } from './dm-don-vi.component';
import { DmDonViDetailComponent } from './dm-don-vi-detail.component';
import { DmDonViUpdateComponent } from './dm-don-vi-update.component';
import { DmDonViDeleteDialogComponent } from './dm-don-vi-delete-dialog.component';
import { dmDonViRoute } from './dm-don-vi.route';

@NgModule({
  imports: [OkmeSharedModule, RouterModule.forChild(dmDonViRoute)],
  declarations: [DmDonViComponent, DmDonViDetailComponent, DmDonViUpdateComponent, DmDonViDeleteDialogComponent],
  entryComponents: [DmDonViDeleteDialogComponent],
})
export class OkmeDmDonViModule {}
