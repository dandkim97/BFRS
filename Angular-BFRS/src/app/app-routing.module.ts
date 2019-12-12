import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddFormComponent } from './add-form/add-form.component';


const routes: Routes = [
  // {
  //   path: '',
  //   redirectTo: '/addform',
  //   pathMatch: 'full'
  // },
  // {
  //   path: 'addform',
  //   component: AddFormComponent
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
