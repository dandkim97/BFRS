import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BeforeReviewComponent } from './before-review.component';

describe('BeforeReviewComponent', () => {
  let component: BeforeReviewComponent;
  let fixture: ComponentFixture<BeforeReviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BeforeReviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BeforeReviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
