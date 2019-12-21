import { Component, OnInit } from '@angular/core';
import { LogintripService } from '../logintrip.service';
import { Logintrip } from '../logintrip';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { Review } from '../review';
import { Router } from '@angular/router';
import { ReviewService } from '../review.service';

@Component({
  selector: 'app-logintrip-list',
  templateUrl: './logintrip-list.component.html',
  styleUrls: ['./logintrip-list.component.css']
})
export class LogintripListComponent implements OnInit {

  logintrips: Logintrip[] = [];
  logintrip: Logintrip;
  customerTrips: Logintrip[];
  currentUser: Login;
  review: Review;

  constructor(
    private logintripService: LogintripService,
    private loginService: LoginService,
    private route: Router,
    private reviewService: ReviewService) { }

  ngOnInit() {
    this.currentUser = this.loginService.getUser();

    this.logintripService.getAllHistoryTrips().subscribe(resp => {
      console.log(resp);
      for (let i = 0; i < resp.length; i++) {
        if (this.currentUser.isAdmin === 0 && (this.currentUser.id === resp[i].userId)) {
          this.logintrips.push(resp[i]);
        }
        if (this.currentUser.isAdmin === 1) {
          this.logintrips = resp;
        }
        this.review = new Review();
        this.reviewService.getReview(this.logintrip.userId, this.logintrip.model).subscribe(
          resp2 => {
            this.review = resp2;
      }
    );
      }
    });
    this.logintrip = new Logintrip();
  }

  isAdmin(): boolean {
    return this.loginService.isAdmin();
  }

  goToReview() {
    this.route.navigate(['review_button', this.logintrip.model]);
  }

  reviewExists(): boolean {
    return (this.review !== undefined && this.review !== null);
  }

}
