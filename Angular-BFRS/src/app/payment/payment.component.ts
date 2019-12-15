import { Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormService } from '../form.service';
import { Form } from '../form';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  tripId: number;
  sub;
  form2: Form;
  isRound: string;

  constructor(private Activatedroute: ActivatedRoute, private formService: FormService) { }

  ngOnInit() {
    this.sub = this.Activatedroute.paramMap.subscribe(params => {
      console.log(params);
      console.log(params.get('id'));
      this.formService.getForm(Number(params.get('id'))).subscribe(
        resp => {
          console.log(resp);
          this.form2 = resp;
          // this.assignForm(this.form);
          if (this.form2.isRound === 0) {
            this.isRound = 'Yes';
          } else {
            this.isRound = 'No';
          }
        });
    });
  }

  // assignForm(form2) {
  //   console.log(this.form);
  //   this.form = form2;
  //   console.log(this.form);
  // }

}
