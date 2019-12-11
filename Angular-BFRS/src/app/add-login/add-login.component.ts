import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-add-login',
  templateUrl: './add-login.component.html',
  styleUrls: ['./add-login.component.css']
})
export class AddLoginComponent implements OnInit {
  @Output() created = new EventEmitter<boolean>();
  login: Login;
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.login = new Login();
  }

  addLogin() {
    this.loginService.addLogin(this.login).subscribe(
      resp => {
        this.created.emit(true);
      });
  }

}
