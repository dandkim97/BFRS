import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { ReviewService } from '../review.service';
import { Review } from '../review';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Plane } from '../plane';
import { PlaneService } from '../plane.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  @Output() crearted = new EventEmitter<boolean>();
  // @Input() logintrip: Logintrip;
  sub;
  review: Review;
  user: Login;
  plane: Plane;

  constructor(private Activatedroute: ActivatedRoute,
              private reviewService: ReviewService,
              private loginService: LoginService,
              private planeService: PlaneService,
              private router: Router) { }

  ngOnInit() {
    this.review = new Review();
    this.user = this.loginService.getUser();
    this.sub = this.Activatedroute.paramMap.subscribe(params => {
        console.log('model: ' + params.get('model'));
        this.planeService.getPlane(params.get('model')).subscribe(
            resp => {
              console.log('resp: ');
              console.log(resp);
              this.plane = resp;
            }
          );
        }
      );
  }

  submit() {
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
