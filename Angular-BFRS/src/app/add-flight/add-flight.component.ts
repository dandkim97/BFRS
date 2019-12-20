import { Component, OnInit, Input } from '@angular/core';
import { Trip } from '../trip';
import { TripService } from '../trip.service';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  @Input() trip: Trip = new Trip();

  constructor(private tripService: TripService) { }

  ngOnInit() {
  }

  submitFlight() {
    
  }
}
