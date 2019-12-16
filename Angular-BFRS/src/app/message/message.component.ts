import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Message } from '../message';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { MessageService } from '../message.service';
import { Router } from '@angular/router';

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
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit() {
    if (!this.message) {
      this.message = new Message();
    }
  }

  redirectToUpdate() {
    if (this.message.type === 'Question') {
      console.log(this.message);
      this.router.navigate(['viewAdminMsg/update', this.message.id]);
    }
  }

}
