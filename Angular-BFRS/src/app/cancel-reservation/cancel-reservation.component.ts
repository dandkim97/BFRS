import { Component, OnInit, Input } from '@angular/core';
import { Logintrip } from '../logintrip';
import { LogintripService } from '../logintrip.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancel-reservation',
  templateUrl: './cancel-reservation.component.html',
  styleUrls: ['./cancel-reservation.component.css']
})
export class CancelReservationComponent implements OnInit {
  @Input() logintrip: Logintrip;
  constructor(
    private logintripService: LogintripService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  cancelFlight() {
    console.log(this.logintrip);
    this.logintripService.cancelLoginTrip(this.logintrip).subscribe(
      resp => {}
    );
    this.router.navigate(['home']);
  }
}
