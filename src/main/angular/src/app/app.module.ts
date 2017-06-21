import { BrowserModule }    from '@angular/platform-browser';
import { NgModule }         from '@angular/core';
import { MdToolbarModule }  from '@angular/material';
import { MdIconModule }     from '@angular/material';
import { MdSidenavModule }  from '@angular/material';
import { RouterModule }     from '@angular/router';

import { AppComponent }     from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MdToolbarModule,
    MdIconModule,
    MdSidenavModule,
    RouterModule.forRoot([])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
