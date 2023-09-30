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
  creatorList: { id: number, name: string }[] = [];

  constructor(private router:Router,private chatService:ChatService)
  {

  }
  ngOnInit(){
    this.getCreatorList();
  }
  getCreatorList(){
   this.fetchAndStoreCreatorList(this.editorId);

  }
  chatNavigate(creatorId:number){
    console.log(creatorId);
    this.router.navigate([`/editor/chat/${creatorId}/${this.editorId}`]);
  }

  async fetchAndStoreCreatorList(editorId: number) {
    try {
      const creatorHashMap = await this.chatService.getCreatorList(editorId);
      console.log(creatorHashMap);
      console.log('Creator List:', this.creatorList);
      const numbers = Object.keys(creatorHashMap).filter(key => !isNaN(parseInt(key)));
      const strings = Object.values(creatorHashMap);
      for (let num of numbers) {
        this.creatorList.push({ id: parseInt(num), name: strings[+num - 1] });
      }
      console.log(this.creatorList);
  
    } catch (error) {
      console.error('Error fetching and storing creator list', error);
    }
  }

}
