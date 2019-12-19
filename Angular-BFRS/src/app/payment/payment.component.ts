import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormService } from '../form.service';
import { Form } from '../form';
import { TripService } from '../trip.service';
import { Trip } from '../trip';
import { Router } from '@angular/router';
import { LogintripService } from '../logintrip.service';
import { Logintrip } from '../logintrip';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();

  sub;
  tripId: number;
  form: Form;
  trip: Trip;
  isRound: string;
  totalPrice: number;
  oldPrice: number;
  seatsPrice: number;
  bagsPrice: number;
  classPrice: number;
  loginTrip: Logintrip = new Logintrip();

  constructor(
    private Activatedroute: ActivatedRoute,
    private formService: FormService,
    private tripService: TripService,
    private loginService: LoginService,
    private loginTripService: LogintripService,
    private router: Router) { }

  ngOnInit() {
    this.sub = this.Activatedroute.paramMap.subscribe(params => {
      console.log(params);
      console.log(params.get('id'));
      this.formService.getForm(Number(params.get('id'))).subscribe(
        resp => {
          console.log(resp);
          this.form = resp;
          if (this.form.isRound === 1) {
            this.isRound = 'Yes';
          } else {
            this.isRound = 'No';
          }
          this.tripService.getTrip(this.form.tripId).subscribe(
            resp2 => {
              console.log(resp2);
              this.trip = resp2;
              this.getTotalPrice();
            });
        });
    });
  }

  getTotalPrice() {
    this.seatsPrice = this.trip.price * (this.form.numSeats);
    this.totalPrice = this.seatsPrice;
    console.log(this.totalPrice);

    if (this.form.numBags === 0) {
      this.bagsPrice = 0;
    }
    if (this.form.numBags === 1) {
      this.bagsPrice = 3;
    }
    if (this.form.numBags === 2) {
      this.bagsPrice = 4;
    }
    if (this.form.numBags === 3) {
      this.bagsPrice = 15;
    }
    if (this.form.numBags > 3) {
      this.bagsPrice = 20 * (this.form.numBags - 3);
    }
    this.totalPrice += this.bagsPrice;
    console.log(this.totalPrice);

    if (this.form.planeClass === 'Economy') {
      this.classPrice = 0;
    }
    if (this.form.planeClass === 'Business') {
      this.classPrice = 250;
    }
    if (this.form.planeClass === 'First Class') {
      this.classPrice = 350;
    }
    this.totalPrice += this.classPrice;
    this.oldPrice = this.totalPrice;
    if (this.isDiscounted()) {
      this.totalPrice -= this.totalPrice * .05;
    }
    console.log(this.totalPrice);
  }

  payFlight() {
    this.loginTrip.login = this.loginService.getUser();
    this.loginTrip.trip = this.trip;
    this.loginTrip.cost = this.totalPrice;
    console.log(this.loginTrip);

    this.loginTripService.addLogintrip(this.loginTrip).subscribe(
      resp => {
        this.created.emit(true);
      });
    document.getElementById('myModal').style.display = 'block';
  }

  cancelPayment() {
    this.router.navigate(['form']);
  }
  
  okHome() {
    this.router.navigate(['home']);

  isDiscounted(): boolean {
    return this.loginService.isLoyalty();
  }
}
