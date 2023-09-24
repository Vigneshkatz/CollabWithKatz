import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Chat } from 'src/app/common/chat/chat';
import { ChatService } from 'src/app/service/chat/chat.service';
import { CreatorService } from 'src/app/service/creator/creator.service';
import { EditorService } from 'src/app/service/editor/editor.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {

  chats: Chat[] = [];
  chatParticipants: { creatorName: string, editorName: string } = {
    creatorName: 'Creator',
    editorName: 'editor'
  };
  inputText: any;
  editorId!:number;
  creatorId!:number;

  constructor(private creatorService: CreatorService, private router: Router,
             private chatService: ChatService, 
             private editorService: EditorService,
             private route:ActivatedRoute) {

  }

  ngOnInit() {
    this.getChat();
    this.getEditor();
    this.getCreator();
    this.getPageDetail();
    this.checkUserType();
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
  getEditor() {
    const editorId = 1;
    const editorName = this.editorService.getEditorInfo(editorId);
    console.log(editorName);
  }
  getCreator() {
    const creatorId = 1;
    const creatorName = this.creatorService.getCreator(creatorId);
    this.chatParticipants.creatorName = creatorName;
    console.log(this.chatParticipants.creatorName);
  }


  getInput(inputText: string) {
    console.log('Input Text:', inputText);
  }

  addMessage(inputText: string){
    console.log('Input Text:', inputText);
    let chat:Chat = new Chat;
    chat.creatorId = 1;
    chat.editorId = 1;
    chat.creatorMessage = inputText;
    chat.editorMessage = "";
    this.chatService.addChat(chat);
    this.refreshPage();
  }

  refreshPage() {
    window.location.reload();
  }

  getPageDetail(){
    this.route.paramMap.subscribe(params => {
      const editorId = params.get('editorId'); 
      const creatorId = params.get('creatorId');
  
      if (editorId !== null && creatorId!==null && editorId !== undefined && creatorId !==undefined) {
        this.editorId=+editorId;
        this.creatorId = +creatorId;
      } else {
        this.router.navigate(['/error']);
      }
    });
    console.log(this.editorId +" "+this.creatorId);
  }

  checkUserType(){
    const routeSegment = this.route.snapshot.url[0].path;
    if (routeSegment === 'creator' ) {
      console.log("creator");
    } else if (routeSegment === 'editor' ) {
      console.log("editor");
    }else{
      this.router.navigate(['/error']);
    }
  }
}
