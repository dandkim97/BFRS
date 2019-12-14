import { Component, OnInit, Input, Output } from '@angular/core';
import { Message } from '../message';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { MessageService } from '../message.service';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  @Input() message: Message;
  @Output() created = new EventEmitter<boolean>();
  user: Login;
  constructor(
    private loginService: LoginService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    if (!this.message) {
      this.message = new Message();
    }
  }

  updateMessage(){
    this.messageService.updateMessage(this.message).subscribe(
      resp => {
        this.created.emit(true);
      }
    )
  }

}
