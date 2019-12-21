import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Logintrip } from '../logintrip';
import { LogintripService } from '../logintrip.service';
import { Router } from '@angular/router';
import { Review } from '../review';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-logintrip',
  templateUrl: './logintrip.component.html',
  styleUrls: ['./logintrip.component.css']
})
export class LogintripComponent implements OnInit {
@Input() logintrip: Logintrip;
@Output() created = new EventEmitter<boolean>();
review: Review;

  constructor(
    private loginTripService: LogintripService,
    private route: Router,
    private reviewService: ReviewService) { }

  ngOnInit() {
    this.review = new Review();
    this.reviewService.getReview(this.logintrip.userId, this.logintrip.model).subscribe(
      resp => {
        this.review = resp;
      }
    );
  }
  goToReview() {
    this.route.navigate(['review_button', this.logintrip.model]);
  }

  reviewExists(): boolean {
    return (this.review !== undefined && this.review !== null);
  }

}
