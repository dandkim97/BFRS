import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';
import { Trip } from '../trip';
import { TripService } from '../trip.service';
import { Plane } from '../plane';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {
  @Output() created = new EventEmitter<Boolean>();
  @Input() form: Form;

  selectedClass;
  class: Array<Object> = [
    { name: 'Economy' },
    { name: 'Business' },
    { name: 'First Class' }
  ];
  tripId: number;
  isChecked = false;

  constructor(private formService: FormService, private tripService: TripService) { }

  ngOnInit() {
    this.form.isRound = 0;
  }

  selectedItem() {
    this.form.planeClass = this.selectedClass.name;
    console.log(this.form.planeClass);
  }

  assignValue(state) {
    if (state.target.checked) {
      this.form.isRound = 1;
    } else {
      this.form.isRound = 0;
    }
    console.log(this.form.isRound);
    console.log(this.form);
  }

  addForm() {
    this.form.tripId = this.tripId;
    console.log(this.tripId);

    // this.tripService.getTrip(this.tripId).subscribe(
    //   trip2 => this.form.trip = trip2);
    // console.log(this.form.trip);

    this.formService.addForm(this.form).subscribe(
      resp => {
        this.created.emit(true);
      });
  }

}
