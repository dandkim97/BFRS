import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Trip } from '../trip';
import { LoginService } from '../login.service';
import { TripService } from '../trip.service';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css']
})
export class UpdateStatusComponent implements OnInit {
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

  isLogin(): boolean {
    return this.loginService.isLogin();
  }

  isAvailable(): boolean {
    return this.trip.status === 'On Time' || this.trip.status === 'Delayed';
  }

  isAdmin(): boolean {
    return this.loginService.isAdmin();
  }

}
