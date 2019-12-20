import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Trip } from '../trip';
import { TripService } from '../trip.service';
import { Plane } from '../plane';
import { PlaneService } from '../plane.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})

export class AddFlightComponent implements OnInit {
  @Output() created = new EventEmitter<boolean>();
  @Input() trip: Trip = new Trip();

  planes: Plane[] = [];
  selectedModel: Plane;

  constructor(
    private tripService: TripService,
    private planeService: PlaneService,
    private router: Router) { }

  ngOnInit() {
    this.planeService.getPlanes().subscribe(
      resp => {
        this.planes = resp;
      });
  }

  selectedItem() {
    console.log(this.selectedModel);
    this.trip.plane = this.selectedModel;
  }

  submitFlight() {
    this.tripService.addTrip(this.trip).subscribe(
      resp => {
        this.created.emit(true);
      });
    console.log(this.trip);

    this.router.navigate(['trips']);
  }
}
