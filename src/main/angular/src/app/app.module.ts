import { BrowserModule }    from '@angular/platform-browser';
import { NgModule }         from '@angular/core';
import { MdToolbarModule }  from '@angular/material';
import { MdIconModule }     from '@angular/material';
import { MdSidenavModule }  from '@angular/material';
import { MdButtonModule }   from '@angular/material';
import { HttpModule }       from '@angular/http';
import { MdListModule }     from '@angular/material';
import { MdCardModule }     from '@angular/material';

import { AppComponent }     from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { ListComponent }    from './principal/list/list.component';
import { PrincipalService } from './principal/principal.service';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    MdToolbarModule,
    MdIconModule,
    MdSidenavModule,
    MdButtonModule,
    HttpModule,
    MdListModule,
    MdCardModule,
    AppRoutingModule
  ],
  providers: [
    PrincipalService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
