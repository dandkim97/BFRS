import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AddLoginComponent } from './add-login/add-login.component';
import { LoginComponent } from './login/login.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { UrlService } from './url.service';
import { LoginService } from './login.service';
import { HomeComponent } from './home/home.component';
import { MessageComponent } from './message/message.component';
import { ViewCustomerMessagesComponent } from './message/view-customer-messages/view-customer-messages.component';

@NgModule({
  declarations: [
    AppComponent,
    AddLoginComponent,
    LoginComponent,
    NavBarComponent,
    HomeComponent,
    MessageComponent,
    ViewCustomerMessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UrlService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
