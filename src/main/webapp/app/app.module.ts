import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { OkmeSharedModule } from 'app/shared/shared.module';
import { OkmeCoreModule } from 'app/core/core.module';
import { OkmeAppRoutingModule } from './app-routing.module';
import { OkmeHomeModule } from './home/home.module';
import { OkmeEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

import { CookieService } from 'ngx-cookie-service';

@NgModule({
  imports: [
    BrowserModule,
    OkmeSharedModule,
    OkmeCoreModule,
    OkmeHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    OkmeEntityModule,
    OkmeAppRoutingModule,
  ],
  providers: [CookieService],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [MainComponent],
})
export class OkmeAppModule {}
