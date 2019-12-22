import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogintripComponent } from './logintrip.component';

describe('LogintripComponent', () => {
  let component: LogintripComponent;
  let fixture: ComponentFixture<LogintripComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogintripComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogintripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
