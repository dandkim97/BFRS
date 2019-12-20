import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMsgComponent } from './admin-msg.component';

describe('AdminMsgComponent', () => {
  let component: AdminMsgComponent;
  let fixture: ComponentFixture<AdminMsgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminMsgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminMsgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
