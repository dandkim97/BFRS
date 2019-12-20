import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Logintrip } from '../logintrip';
import { LogintripService } from '../logintrip.service';

@Component({
  selector: 'app-logintrip',
  templateUrl: './logintrip.component.html',
  styleUrls: ['./logintrip.component.css']
})
export class LogintripComponent implements OnInit {
@Input() logintrip: Logintrip;
@Output() created = new EventEmitter<boolean>();

  constructor(
    private loginTripService: LogintripService
  ) { }

  ngOnInit() {
  }

  cancelFlight() {
    console.log(this.logintrip);
    this.loginTripService.cancelLoginTrip(this.logintrip).subscribe(
      resp => {
        this.created.emit(true);
      }
    );
  }

}
