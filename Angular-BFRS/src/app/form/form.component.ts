import { Component, OnInit, Input } from '@angular/core';
import { Form } from '../form';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  @Input() form: Form;
  constructor() { }

  ngOnInit() {
  }

}
