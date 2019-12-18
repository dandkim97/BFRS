import { Component, OnInit } from '@angular/core';
import { Message } from '../message';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-admin-msg',
  templateUrl: './admin-msg.component.html',
  styleUrls: ['./admin-msg.component.css']
})
export class AdminMsgComponent implements OnInit {

  messages: Message[];

  constructor(
    private messageService: MessageService,
  ) { }

  ngOnInit() {
    this.messageService.getAdminMsgs().subscribe((m) => {this.messages = m; });
  }

}
