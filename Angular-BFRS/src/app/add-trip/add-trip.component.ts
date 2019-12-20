import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Trip } from '../trip';
import { TripService } from '../trip.service';
import { Plane } from '../plane';

@Component({
  selector: 'app-add-trip',
  templateUrl: './add-trip.component.html',
  styleUrls: ['./add-trip.component.css']
})
export class AddTripComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() trip: Trip;

  constructor(private tripService: TripService) { }

  ngOnInit() {
  }

  addTrip() {
    //this.trip.id = this.tripId;
    //console.log(this.tripId);
    //console.log("I am working");

  this.tripService.addTrip(this.trip).subscribe(
    resp => {
      this.created.emit(true);
    });
}

}
