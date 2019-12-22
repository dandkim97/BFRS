import { Component, OnInit, Input } from '@angular/core';
import { Review } from '../review';
import { Router } from '@angular/router';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-before-review',
  templateUrl: './before-review.component.html',
  styleUrls: ['./before-review.component.css']
})
export class BeforeReviewComponent implements OnInit {
  @Input() logintrip;
  review: Review;

  constructor(private route: Router, private reviewService: ReviewService) { }

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
