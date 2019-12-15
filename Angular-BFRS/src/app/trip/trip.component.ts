import { Component, OnInit, Input } from '@angular/core';
import {Trip} from '../trip';

@Component({
  selector: 'app-trip',
  templateUrl: './trip.component.html',
  styleUrls: ['./trip.component.css']
})
export class TripComponent implements OnInit {
  @Input() trip: Trip;

  constructor() { }

  ngOnInit() {
  }

}
