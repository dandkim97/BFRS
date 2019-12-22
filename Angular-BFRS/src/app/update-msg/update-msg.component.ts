import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MessageService } from '../message.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from '../message';

@Component({
  selector: 'app-update-msg',
  templateUrl: './update-msg.component.html',
  styleUrls: ['./update-msg.component.css']
})
export class UpdateMsgComponent implements OnInit {
  public message: Message;
  @Output() created = new EventEmitter<boolean>();
  constructor(
    private messageService: MessageService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    console.log('Hello from updateMsg');
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

  updateQuestion() {
    this.messageService.updateMessage(this.message).subscribe(
      resp => {
        this.created.emit(true);
        this.router.navigate(['viewAdminMsg']);
      }
    );
  }

}
