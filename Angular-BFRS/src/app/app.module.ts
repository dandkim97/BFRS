import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { AddFormComponent } from './add-form/add-form.component';
import { FormService } from './form.service';
import { FormListComponent } from './form-list/form-list.component';
import { TripService } from './trip.service';
import { TripComponent } from './trip/trip.component';
import { TripListComponent } from './trip-list/trip-list.component';
import { PlaneComponent } from './plane/plane.component';

import { AddLoginComponent } from './add-login/add-login.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { UrlService } from './url.service';
import { LoginService } from './login.service';
import { HomeComponent } from './home/home.component';
import { MessageComponent } from './message/message.component';
import { AdminMsgComponent } from './admin-msg/admin-msg.component';
import { MessageService } from './message.service';
import { UpdateMsgComponent } from './update-msg/update-msg.component';
import { ViewCustomerMessagesComponent } from './message/view-customer-messages/view-customer-messages.component';
import { ReviewComponent } from './review/review.component';
import { LoyaltyReqMsgComponent } from './loyalty-req-msg/loyalty-req-msg.component';
import { PaymentComponent } from './payment/payment.component';
import { LogintripComponent } from './logintrip/logintrip.component';
import { LogintripListComponent } from './logintrip-list/logintrip-list.component';
import { BeforeReviewComponent } from './before-review/before-review.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { LogintripService } from './logintrip.service';
import { ReviewService } from './review.service';
import { PlaneService } from './plane.service';
import { CancelReservationComponent } from './cancel-reservation/cancel-reservation.component';
import { UpdateStatusComponent } from './update-status/update-status.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    AddFormComponent,
    FormListComponent,
    TripComponent,
    TripListComponent,
    PlaneComponent,
    AddLoginComponent,
    LoginComponent,
    NavBarComponent,
    HomeComponent,
    MessageComponent,
    ReviewComponent,
    AdminMsgComponent,
    UpdateMsgComponent,
    ViewCustomerMessagesComponent,
    PaymentComponent,
    LogintripComponent,
    LogintripListComponent,
    LoyaltyReqMsgComponent,
    BeforeReviewComponent,
    AddFlightComponent,
    CancelReservationComponent,
    UpdateStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    FormService,
    TripService,
    UrlService,
    LoginService,
    MessageService,
    LogintripService,
    ReviewService,
    PlaneService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
