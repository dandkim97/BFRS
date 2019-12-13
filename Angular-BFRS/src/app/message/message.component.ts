import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../message';
import { LoginService } from '../login.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  @Input() message: Message;
  constructor(
    private loginService: LoginService,
    private messageService: MessageService
  ) { }

  ngOnInit() {
    if (!this.message) {
      this.message = new Message();
    }
  }

}
