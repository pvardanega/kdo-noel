import { BrowserModule }    from '@angular/platform-browser';
import { NgModule }         from '@angular/core';
import { MdToolbarModule }  from '@angular/material';
import { MdIconModule }     from '@angular/material';
import { MdSidenavModule }  from '@angular/material';
import { HttpModule }       from '@angular/http';
import { RouterModule }     from '@angular/router';

import { AppComponent }     from './app.component';
import { PrincipalService } from './principal/principal.service';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MdToolbarModule,
    MdIconModule,
    MdSidenavModule,
    HttpModule,
    RouterModule.forRoot([])
  ],
  providers: [
    PrincipalService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
