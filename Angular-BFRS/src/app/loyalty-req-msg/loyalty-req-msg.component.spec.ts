import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoyaltyReqMsgComponent } from './loyalty-req-msg.component';

describe('LoyaltyReqMsgComponent', () => {
  let component: LoyaltyReqMsgComponent;
  let fixture: ComponentFixture<LoyaltyReqMsgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoyaltyReqMsgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoyaltyReqMsgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
