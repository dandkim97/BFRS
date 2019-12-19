import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ReviewService } from '../review.service';
import { Review } from '../review';
import { Login } from '../login';
import { Plane } from '../plane';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  @Output() crearted = new EventEmitter<boolean>();
  review: Review;
  user: Login;
  plane: Plane;

  constructor(private reviewService: ReviewService, private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.review = new Review();
    this.user = this.loginService.getUser();
  }

  submit() {
    this.plane = new Plane();
    this.plane.id = 3;
    this.review.plane = this.plane;
    this.review.customer = this.user;
    this.reviewService.addReview(this.review).subscribe(
      resp => {
        this.crearted.emit(true);
        this.router.navigate(['home']);
      }
    );
  }

}
