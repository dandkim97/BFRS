import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { AddFormComponent } from './add-form/add-form.component';
import { UrlService } from './url.service';
import { FormService } from './form.service';
import { FormListComponent } from './form-list/form-list.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    AddFormComponent,
    FormListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UrlService,
    FormService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
