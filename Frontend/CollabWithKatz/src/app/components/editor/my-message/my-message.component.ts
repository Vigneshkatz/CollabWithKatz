import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ChatService } from 'src/app/service/chat/chat.service';

@Component({
  selector: 'app-my-message',
  templateUrl: './my-message.component.html',
  styleUrls: ['./my-message.component.css']
})
export class MyMessageComponent {
  private creatorId:number = 1;
  private editorId:number = 1;

  constructor(private router:Router,private chatService:ChatService)
  {

  }
  ngOnInit(){
    this.getCreatorList();
  }
  getCreatorList(){
    console.log(this.chatService.getCreatorList(this.editorId))

  }
  chatNavigate(){
    this.router.navigate([`/editor/chat/${this.creatorId}/${this.editorId}`]);
  }
}
