import { Component, OnInit } from '@angular/core';
import { TripService } from '../trip.service';
import { Trip } from '../trip';
import { Plane } from '../plane';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {

  trips: Trip[];
  trip: Trip;

  constructor(
    private tripService: TripService,
    private loginService: LoginService,
    private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit() {
    this.tripService.getTrips().subscribe(resp => {
      this.trips = resp;
    });
    this.trip = new Trip();
    this.trip.plane = new Plane();
  }

  submitted() {
    this.trips.push(this.trip);
    this.trip = new Trip();
    this.trip.plane = new Plane();
  }

  addFlight() {
    this.router.navigate(['addflight']);
  }

  isLogin(): boolean {
    return this.loginService.isLogin();
  }

  isAdmin(): boolean {
    return this.loginService.isAdmin();
  }

}
