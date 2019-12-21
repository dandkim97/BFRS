import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';
import { Router } from '@angular/router';
import { TripService } from '../trip.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit {
  @Output() created = new EventEmitter<boolean>();
  @Input() form: Form;

  selectedClass;
  class: Array<object> = [
    { name: 'Economy' },
    { name: 'Business' },
    { name: 'First Class' }
  ];
  isChecked = false;
  numFlights: number;
  forms: Form[] = [];
  form2: Form = new Form();

  constructor(
    private formService: FormService,
    private router: Router,
    private tripService: TripService,
    private loginService: LoginService) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit() {
    this.form.isRound = 0;
    this.tripService.getTrips().subscribe(
      resp => {
        this.numFlights = resp.length;
      });
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
    this.form.loginId = this.loginService.getUser().id;
    console.log(this.form);
    this.formService.addForm(this.form).subscribe(
      resp => {
        this.created.emit(true);
        this.formService.getForms().subscribe(
          resp2 => {
            this.forms = resp2;
            this.forms.sort((a, b) => (a.id > b.id) ? 1 : -1);
            console.log(this.forms);
            const formsLength: number = this.forms.length;
            console.log(formsLength);
            this.form2 = this.forms[formsLength - 1];
            console.log(this.form2);
            this.router.navigate(['payment', this.form2.id]);
          });
      });
  }

  checkPlaneNum(e) {
    const x = Number((document.getElementById('idPlaneNum') as HTMLInputElement).value);

    if (x < 1 || x > this.numFlights) {
      e.target.value = 1;
    }
  }

  checkNumSeats(e) {
    const x = Number((document.getElementById('idNumSeats') as HTMLInputElement).value);

    if (x < 1) {
      e.target.value = 1;
    }
  }

  checkNumBags(e) {
    const x = Number((document.getElementById('idNumBags') as HTMLInputElement).value);

    if (x < 0) {
      e.target.value = 0;
    }
  }
}
