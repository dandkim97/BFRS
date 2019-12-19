import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogintripListComponent } from './logintrip-list.component';

describe('LogintripListComponent', () => {
  let component: LogintripListComponent;
  let fixture: ComponentFixture<LogintripListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogintripListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogintripListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
