import { Component, OnInit } from '@angular/core';
import { Message } from 'src/app/message';
import { MessageService } from 'src/app/message.service';
import { LoginService } from 'src/app/login.service';
import { Login } from 'src/app/login';

@Component({
  selector: 'app-view-customer-messages',
  templateUrl: './view-customer-messages.component.html',
  styleUrls: ['./view-customer-messages.component.css']
})
export class ViewCustomerMessagesComponent implements OnInit {
  messages: Message[];
  message: Message;
  user: Login;
  constructor(private messageService: MessageService, private loginService: LoginService) { }

  ngOnInit() {
    this.user = this.loginService.getUser();
    this.messageService.getMessagesCustomer(this.user).subscribe( resp => {
      console.log(resp);
      this.messages = resp;
    });
    console.log(this.messages);
    this.message = new Message();
  }

}
