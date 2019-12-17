import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormService } from '../form.service';
import { Form } from '../form';
import { TripService } from '../trip.service';
import { Trip } from '../trip';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  sub;
  tripId: number;
  form: Form;
  trip: Trip;
  isRound: string;
  totalPrice: number;

  constructor(private Activatedroute: ActivatedRoute, private formService: FormService,
    private tripService: TripService, private router: Router) { }

  ngOnInit() {
    this.sub = this.Activatedroute.paramMap.subscribe(params => {
      console.log(params);
      console.log(params.get('id'));
      this.formService.getForm(Number(params.get('id'))).subscribe(
        resp => {
          console.log(resp);
          this.form = resp;
          if (this.form.isRound === 0) {
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
    this.totalPrice = this.trip.price * (this.form.numSeats);
    console.log(this.totalPrice);

    if (this.form.numBags === 1) {
      this.totalPrice += this.trip.price + 3;
    }
    if (this.form.numBags === 2) {
      this.totalPrice += this.trip.price + 4;
    }
    if (this.form.numBags === 3) {
      this.totalPrice += this.trip.price + 15;
    }
    if (this.form.numBags > 3) {
      this.totalPrice += this.trip.price + (20 * (this.form.numBags - 3));
    }
    console.log(this.totalPrice);

    if (this.form.planeClass === 'Business') {
      this.totalPrice += 250;
    }
    if (this.form.planeClass === 'First Class') {
      this.totalPrice += 350;
    }
    console.log(this.totalPrice);
  }

  payFlight() {

  }

  cancelPayment() {
    this.router.navigate(['form']);
  }
}
