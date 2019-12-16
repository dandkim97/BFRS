import { Component, OnInit } from '@angular/core';
import {LogintripService} from '../logintrip.service';
import { Logintrip } from '../logintrip';
import { Trip } from '../trip';
import { Login } from '../login';
@Component({
  selector: 'app-logintrip-list',
  templateUrl: './logintrip-list.component.html',
  styleUrls: ['./logintrip-list.component.css']
})
export class LogintripListComponent implements OnInit {

  logintrips: Logintrip[];
  logintrip: Logintrip;

  constructor(private logintripService: LogintripService) { }

  ngOnInit() {
    this.logintripService.getLogintrips().subscribe( resp => {
      this.logintrips = resp;
    });
    this.logintrip = new Logintrip();
    this.logintrip.login = new Login();
    this.logintrip.trip = new Trip();
  }

}
