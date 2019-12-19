import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import {Trip} from '../trip';
import { LoginService } from '../login.service';
import { TripService } from '../trip.service';

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent implements OnInit {
  @Input() trip: Trip;
  @Output() created = new EventEmitter<boolean>();

  constructor(
    private loginService: LoginService,
    private tripService: TripService
  ) { }

  ngOnInit() {
  }

  updateStatus() {
    this.tripService.updateTrip(this.trip).subscribe(
      resp => {
        this.created.emit(true);
    });
    document.getElementById('myModal').style.display = 'block';
  }

  okHome() {
    document.getElementById('myModal').style.display = 'none';
  }
  isAdmin(): boolean {
    return this.loginService.isAdmin();
  }

  isLogin(): boolean {
    return this.loginService.isLogin();
  }
}
