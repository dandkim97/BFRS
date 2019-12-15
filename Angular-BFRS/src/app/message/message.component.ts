import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Message } from '../message';
import { MessageService } from '../message.service';
import { Router } from '@angular/router';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  @Output() created = new EventEmitter<boolean>();
  message: Message;
  user: Login;
  constructor(private messageService: MessageService, private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    this.message = new Message();
    this.user = this.loginService.getUser();
  }

  addMessage() {
    this.message.askerId = this.user.id;
    this.message.askedId = 1;
    this.message.status = 'pending';
    this.messageService.addMessage(this.message).subscribe(
      resp => {
        this.created.emit(true);
        this.router.navigate(['home']);
      }
    );
  }

}
