import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TripComponent } from './trip/trip.component';
import { PlaneComponent } from './plane/plane.component';
import { TripListComponent } from './trip-list/trip-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TripComponent,
    PlaneComponent,
    TripListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
