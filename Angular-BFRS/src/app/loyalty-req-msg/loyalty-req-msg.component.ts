import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Message } from '../message';
import { MessageService } from '../message.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-loyalty-req-msg',
  templateUrl: './loyalty-req-msg.component.html',
  styleUrls: ['./loyalty-req-msg.component.css']
})
export class LoyaltyReqMsgComponent implements OnInit {
  public message: Message;
  @Output() created = new EventEmitter<boolean>();
  constructor(
    private messageService: MessageService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    console.log('Hello from loyaltyReqMsg');
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    if (id) {
      this.messageService.getMessage(id).subscribe(
        message => {
          this.message = message;
        }
      );
    }
  }
  approve() {
    this.messageService.isApproved = true;
    console.log(this.messageService.isApproved);
    this.messageService.updateMessage(this.message).subscribe(
      resp => {
        this.created.emit(true);
        this.router.navigate(['viewAdminMsg']);
      }
    );
  }
  reject() {
    this.messageService.isApproved = false;
    this.messageService.updateMessage(this.message).subscribe(
      resp => {
        this.created.emit(true);
        this.router.navigate(['viewAdminMsg']);
      }
    );
  }
}
