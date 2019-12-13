import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Login } from '../login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loggedUser: Login;
  public username: string;
  public password: string;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.loginService.login(null, null).subscribe(
      resp => {
        this.loggedUser = resp;
      }
    );
  }

  login() {
    console.log('login() in login.comp is called');
    console.log(this.username + ' ' + this.password);
    this.loginService.login(this.username, this.password).subscribe(
      resp => {
        this.loggedUser = resp;
        console.log(resp);
        console.log(this.loggedUser);
      }
    );
  }

  logout() {
    this.loginService.logout().subscribe(
      resp => {
        this.loggedUser = null;
      }
    );
  }

}
