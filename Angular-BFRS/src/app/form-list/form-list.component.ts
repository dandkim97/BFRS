import { Component, OnInit } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';

@Component({
  selector: 'app-form-list',
  templateUrl: './form-list.component.html',
  styleUrls: ['./form-list.component.css']
})
export class FormListComponent implements OnInit {
  forms: Form[];
  form: Form;
  constructor(private formService: FormService) { }

  ngOnInit() {
    this.formService.getForms().subscribe(resp => {
      this.forms = resp;
    });
    this.form = new Form();
  }

  submitted() {
    this.forms.push(this.form);
    this.form = new Form();
    console.log('New form added.');
  }
}
