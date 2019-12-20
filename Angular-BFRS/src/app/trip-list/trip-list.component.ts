import { Component, OnInit } from '@angular/core';
import { TripService } from '../trip.service';
import { Trip } from '../trip';
import { Plane } from '../plane';
@Component({
  selector: 'app-trip-list',
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css']
})
export class TripListComponent implements OnInit {

  trips: Trip[];
  trip: Trip;
  constructor(private tripService: TripService) { }

  ngOnInit() {
    this.tripService.getTrips().subscribe( resp => {
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

}
