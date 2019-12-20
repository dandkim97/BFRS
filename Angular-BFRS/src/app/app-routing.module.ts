import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddLoginComponent } from './add-login/add-login.component';
import { AdminMsgComponent } from './admin-msg/admin-msg.component';
import { UpdateMsgComponent } from './update-msg/update-msg.component';
import { MessageComponent } from './message/message.component';
import { ViewCustomerMessagesComponent } from './message/view-customer-messages/view-customer-messages.component';
import { FormListComponent } from './form-list/form-list.component';
import { TripListComponent } from './trip-list/trip-list.component';
import { ReviewComponent } from './review/review.component';
import { LoyaltyReqMsgComponent } from './loyalty-req-msg/loyalty-req-msg.component';
import { PaymentComponent } from './payment/payment.component';
import { LogintripListComponent } from './logintrip-list/logintrip-list.component';
import { AddFlightComponent } from './add-flight/add-flight.component';

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
    path: 'viewAdminMsg',
    component: AdminMsgComponent
  },
  {
    path: 'viewAdminMsg/update/:id',
    component: UpdateMsgComponent
  },
  {
    path: 'viewAdminMsg/loyaltyReq/:id',
    component: LoyaltyReqMsgComponent
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
    path: 'review',
    component: ReviewComponent
  },
  {
    path: 'payment/:id',
    component: PaymentComponent
  },
  {
    path: 'logintrips',
    component: LogintripListComponent
  },
  {
    path: 'addflight',
    component: AddFlightComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
