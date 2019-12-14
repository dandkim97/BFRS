import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddLoginComponent } from './add-login/add-login.component';
import { FormListComponent } from './form-list/form-list.component';
import { AddFormComponent } from './add-form/add-form.component';
import { TripListComponent } from './trip-list/trip-list.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'add',
    component: AddLoginComponent
  },
  {
    path: 'form',
    component: FormListComponent
  }
  ,
  {
    path: 'trip',
    component: TripListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
