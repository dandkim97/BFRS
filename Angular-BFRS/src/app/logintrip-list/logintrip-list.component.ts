import { Component, OnInit } from '@angular/core';
import { LogintripService } from '../logintrip.service';
import { Logintrip } from '../logintrip';
import { Trip } from '../trip';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-logintrip-list',
  templateUrl: './logintrip-list.component.html',
  styleUrls: ['./logintrip-list.component.css']
})
export class LogintripListComponent implements OnInit {

  logintrips: Logintrip[] = [];
  logintrip: Logintrip;
  customerTrips: Logintrip[];
  currentUser: Login;

  constructor(private logintripService: LogintripService, private loginService: LoginService) { }

  ngOnInit() {
    this.currentUser = this.loginService.getUser();

    this.logintripService.getAllHistoryTrips().subscribe(resp => {


      // this.logintrips = resp;

      for (let i = 0; i < resp.length; i++) {
        if (this.currentUser.isAdmin === 0 && (this.currentUser.id === resp[i].userId)) {
          this.logintrips.push(resp[i]);
        }
        if (this.currentUser.isAdmin === 1) {
          this.logintrips = resp;
        }
        // if (resp[i].login.isAdmin === 0 && (this.currentUser.id === resp[i].login.id)) {
        //   this.logintrips = resp;
        // }
      }
    });
    this.logintrip = new Logintrip();
   // this.logintrip.login = new Login();
   // this.logintrip.trip = new Trip();
    // this.getUserTrips();
  }

  // getUserTrips() {
  //   this.logintripService.getLogintrips().subscribe(
  //     resp => {

  //     });
  // }

}
