import { Component, OnInit, Input } from '@angular/core';
import { Logintrip } from '../logintrip';

@Component({
  selector: 'app-logintrip',
  templateUrl: './logintrip.component.html',
  styleUrls: ['./logintrip.component.css']
})
export class LogintripComponent implements OnInit {
@Input() logintrip: Logintrip;

  constructor() { }

  ngOnInit() {
  }



}
