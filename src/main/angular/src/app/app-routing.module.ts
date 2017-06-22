import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListComponent }  from './principal/list/list.component';

const routes: Routes = [
  { path: '', redirectTo: '/my-list', pathMatch: 'full' },
  { path: 'my-list', component: ListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
