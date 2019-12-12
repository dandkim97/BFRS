import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';

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

  isChecked = false;

  constructor(private formService: FormService) { }

  ngOnInit() {

  }

  selectedItem() {
    this.form.planeClass = this.selectedClass.name;
    console.log(this.form.planeClass);
  }

  assignValue(state) {
    if (state.target.checked === true) {
      this.form.isRound = 1;
    } else {
      this.form.isRound = 0;
    }
    console.log(this.form.isRound);
    console.log(this.form);
  }

  addForm() {
    this.formService.addForm(this.form).subscribe(
      resp => {
        this.created.emit(true);
      });
  }

}
