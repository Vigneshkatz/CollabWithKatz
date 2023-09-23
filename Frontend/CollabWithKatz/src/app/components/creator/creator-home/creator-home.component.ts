import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Chat } from 'src/app/common/chat/chat';
import { ChatService } from 'src/app/service/chat/chat.service';
import { CreatorService } from 'src/app/service/creator/creator.service';

@Component({
  selector: 'app-creator-home',
  templateUrl: './creator-home.component.html',
  styleUrls: ['./creator-home.component.css']
})
export class CreatorHomeComponent {
  editorList: any[] = [];
  sortValue: string = '';
  isChatVisible: boolean = false;
  chatOpenState: { [key: number]: boolean } = {};
  chats: Chat[] = [];
  chatParticipants: { creatorName: string, editorName: string } = {
    creatorName: 'hello',
    editorName: ''
  };

  constructor(private creatorService: CreatorService, private router: Router, private chatService: ChatService) {

  }

  ngOnInit() {
    this.getEditorList();
    this.getCreator();
    this.getChat();
    console.log(this.editorList);
  }
  getEditorList() {
    this.creatorService.getAllEditor()
      .then((data: any[]) => {
        this.editorList = data;
        this.executeAfterHTTP();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  executeAfterHTTP() {
    console.log("Code executed after HTTP request:", this.editorList);
  }

  onCollab() {
    const creatorId = 1;
    const editorId = 1;
    console.log('onCollab() function called');
    this.router.navigate(['/creator/collab', creatorId, editorId]);
  }

  logout() {
    this.router.navigate(['/login']);
  }

  sortBy() {
    this.creatorService.sortEditorBy(this.sortValue).then((data: any[]) => {
      this.editorList = data;
      this.executeAfterHTTP();
    })
      .catch((error: any) => {
        console.error(error);
        this.router.navigate(['/error']);
      });
    console.log(this.editorList);

  }

  viewProfile(editorId: number) {
    this.router.navigate(['/profilePage', editorId]);
  }

  toggleChat(editorId: number, editorName: string) {
    this.isChatVisible = !this.isChatVisible;
    this.chatOpenState[editorId] = !this.chatOpenState[editorId];
    this.chatParticipants.editorName = editorName;
  }

  getMessageButtonLabel() {
    return this.isChatVisible ? 'Close Message' : 'Message';
  }

  isChatOpen(editorId: number): boolean {
    return !!this.chatOpenState[editorId];
  }

  getChat() {
    this.chatService.getChat(1, 1).subscribe(
      (chats: Chat[]) => {
        this.chats = chats;
        console.log(this.chats);
      },
      (error: any) => {
        console.error('Error fetching chat:', error);
      }
    );
  }

  getCreator(){
    const creatorId =4;
    const creatorName = this.creatorService.getCreator(creatorId);
    // this.chatParticipants.creatorName = creatorName;
    console.log(this.chatParticipants.creatorName);
  }
}
