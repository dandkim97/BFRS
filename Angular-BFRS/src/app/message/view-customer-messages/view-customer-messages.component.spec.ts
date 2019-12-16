import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCustomerMessagesComponent } from './view-customer-messages.component';

describe('ViewCustomerMessagesComponent', () => {
  let component: ViewCustomerMessagesComponent;
  let fixture: ComponentFixture<ViewCustomerMessagesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCustomerMessagesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCustomerMessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
