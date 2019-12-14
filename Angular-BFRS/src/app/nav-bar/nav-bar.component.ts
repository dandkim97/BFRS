import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  title = 'BAGDAD Flight Reservation Service';
  constructor(public route: Router, private loginService: LoginService) {}

  ngOnInit() { }

  isLogin(): boolean  {
    return this.loginService.isLogin();
  }
}
