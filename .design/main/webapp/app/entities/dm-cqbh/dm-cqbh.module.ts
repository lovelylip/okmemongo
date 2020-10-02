import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { OkmeSharedModule } from 'app/shared/shared.module';
import { DmCqbhComponent } from './dm-cqbh.component';
import { DmCqbhDetailComponent } from './dm-cqbh-detail.component';
import { DmCqbhUpdateComponent } from './dm-cqbh-update.component';
import { DmCqbhDeleteDialogComponent } from './dm-cqbh-delete-dialog.component';
import { dmCqbhRoute } from './dm-cqbh.route';

@NgModule({
  imports: [OkmeSharedModule, RouterModule.forChild(dmCqbhRoute)],
  declarations: [DmCqbhComponent, DmCqbhDetailComponent, DmCqbhUpdateComponent, DmCqbhDeleteDialogComponent],
  entryComponents: [DmCqbhDeleteDialogComponent],
})
export class OkmeDmCqbhModule {}
