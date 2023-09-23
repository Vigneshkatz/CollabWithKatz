import { Injectable } from '@angular/core';
import { BackendService } from '../backend/backend.service';
import { Chat } from 'src/app/common/chat/chat';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  constructor(private backendService: BackendService) { }

  getChat(creatorId: number, editorId: number): Observable<Chat[]> {
    return this.backendService.getChat(creatorId, editorId);
  }

  addChat(chat: Chat) {
    this.backendService.addChat(chat).subscribe(
      (chats: Chat) => {
        console.log(chats);
      },
      (error: any) => {
        console.error('Error fetching chat:', error);
      }
    );;
  }
}

