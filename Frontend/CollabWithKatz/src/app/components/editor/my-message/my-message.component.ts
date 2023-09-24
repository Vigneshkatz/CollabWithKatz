import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-message',
  templateUrl: './my-message.component.html',
  styleUrls: ['./my-message.component.css']
})
export class MyMessageComponent {
  private creatorId:number = 1;
  private editorId:number = 1;

  constructor(private router:Router)
  {

  }

  chatNavigate(){
    this.router.navigate([`/creator/chat/${this.creatorId}/${this.editorId}`]);
  }
}
