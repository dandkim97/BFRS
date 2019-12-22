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
// message: Message;
  user: Login;
  constructor(
    private loginService: LoginService,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit() {
    if (!this.message) {
      this.message = new Message();
      this.message.type = 'Question';
    }
    this.user = this.loginService.getUser();
  }

  redirectToUpdate() {
    if (this.message.type === 'Question') {
      console.log(this.message);
      this.router.navigate(['viewAdminMsg/update', this.message.id]);
    } else
    if (this.message.type === 'Loyalty Request') {
      console.log(this.message);
      this.router.navigate(['viewAdminMsg/loyaltyReq', this.message.id]);
    }
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

  isAdmin(): boolean {
    return this.loginService.isAdmin();
  }
}
