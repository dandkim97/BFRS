import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddLoginComponent } from './add-login/add-login.component';
import { MessageComponent } from './message/message.component';
import { ViewCustomerMessagesComponent } from './message/view-customer-messages/view-customer-messages.component';
import { FormListComponent } from './form-list/form-list.component';
import { AddFormComponent } from './add-form/add-form.component';
import { TripListComponent } from './trip-list/trip-list.component';
import { LogintripListComponent } from './logintrip-list/logintrip-list.component';

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
    path: 'message',
    component: MessageComponent
  },
  {
    path: 'view_customer_messages',
    component: ViewCustomerMessagesComponent
  },
  {
    path: 'form',
    component: FormListComponent
  },
  {
    path: 'trips',
    component: TripListComponent
  },
  {
    path: 'logintrips',
    component: LogintripListComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
