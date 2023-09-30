import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, of, throwError } from 'rxjs';
import { Editor } from 'src/app/common/editor/editor';
import { Project } from 'src/app/common/project/project';
import { Chat } from 'src/app/common/chat/chat';
import { Creator } from 'src/app/common/creator/creator';

@Injectable({
  providedIn: 'root'
})
export class BackendService {


  private BASEURL:string = 'http://localhost:8000';
  private EDITOR_BASEURL: string = `${this.BASEURL}/v1/editors`;
  private CREATOR_BASEURL:string = `${this.BASEURL}/v1/creators`;

  constructor(private http: HttpClient) { }

  // login
  login(editor_email: string, editor_password: string): Observable<boolean> {
    const LOGIN_URL = `${this.EDITOR_BASEURL}/byEmail?email=${editor_email}&password=${editor_password}`;
    return this.http.get(LOGIN_URL).pipe(
      map((response) => {
        // Check the response for login success (you might need to adjust this based on your API response format)
        if (response ) {
          console.log('Login successful.');
          return true;
        } else {
          console.log('Login failed.');
          return false;
        }
      }),
      catchError((error) => {
        console.error('Error:', error);
        return of(false);
      })
    );
  }

  // register

  signUp(editor: Editor): Observable<Editor> {
    const ADD_EDITOR = `${this.EDITOR_BASEURL}/addEditor`;
    return this.http.post<Editor>(ADD_EDITOR,editor);
  }
  // get editor by email
  getEditorByEditorId(editor_id: number): Observable<any> {
    console.log("signup editor backend");
    const GET_EDITOR_DETAIL_BY_ID_URL = `${this.EDITOR_BASEURL}/editorById?id=${editor_id}`;
    return this.http.get<any>(GET_EDITOR_DETAIL_BY_ID_URL);

  }
  
  // Creator section

  creatorLogin(user_email: string, user_password: string) :Observable<boolean>{
    const CREATOR_LOGIN_URL = `${this.CREATOR_BASEURL}/login?email=${user_email}&password=${user_password}`
    return this.http.get(CREATOR_LOGIN_URL).pipe(
      map((response) => {
        // Check the response for login success (you might need to adjust this based on your API response format)
        if (response ) {
          console.log('Login successful.');
          return true;
        } else {
          console.log('Login failed.');
          return false;
        }
      }),
      catchError((error) => {
        console.error('Error:', error);
        return of(false);
      })
    );
  }

  addCreator(creator: Creator):Observable<Creator> {
    const Add_Creator = `${this.CREATOR_BASEURL}/add`;
    return this.http.post<Creator>(Add_Creator,creator);
  }

  getAllEditor(): any {
    const GET_ALL_EDITOR = `${this.EDITOR_BASEURL}/allEditors`;
    return this.http.get(GET_ALL_EDITOR);
    
  }

  getProjectByEditorId(editorId: number):any {
    const GET_ALL_CREATOR_PROJECT = `${this.EDITOR_BASEURL}/${editorId}/getProjects`;
    return this.http.get(GET_ALL_CREATOR_PROJECT);
  }

  sortEditorsBy(sortBy:string):Observable<any>{
    console.log(`${sortBy} creator service` );
    const GET_EDITORLIST_BY_SORT=`${this.EDITOR_BASEURL}/sortBy/${sortBy}`;
    return this.http.get(GET_EDITORLIST_BY_SORT);
  }

  projectByCreatorId(creatorId: any):any {
    const GET_ALL_EDITOR_PROJECT = `${this.EDITOR_BASEURL}/${creatorId}/getProjects`;
    return this.http.get(GET_ALL_EDITOR_PROJECT);
  }

  //addProject

  addProject(project:Project): any{
    const ADD_PROJECT = `${this.CREATOR_BASEURL}/addProject`;
    return this.http.post(ADD_PROJECT,project);
  }

  // chat

  getChat(creatorId: number, editorId: number): Observable<Chat[]> {
    const GET_CHAT = `${this.BASEURL}/chat/getChat/${creatorId}/${editorId}`;
    return this.http.get<Chat[]>(GET_CHAT);
  }

  getCreatorDetail(creatorId: number):Observable<any>{
    const GET_CREATOR_DETAIL = `${this.CREATOR_BASEURL}/getCreator/${creatorId}`;
    console.log(GET_CREATOR_DETAIL);
    return this.http.get(GET_CREATOR_DETAIL);
  }

  addChat(chat: Chat):Observable<Chat> {
    const ADD_CHAT = `${this.BASEURL}/chat/addChat`;
    return this.http.post<Chat>(ADD_CHAT,chat);
  }

  getCreatorChatList(editorId: number):Observable<any> {
    const GET_EDITOR_CHAT_LIST = `${this.BASEURL}/chat/getCreatorList/${editorId}`;
    return this.http.get(GET_EDITOR_CHAT_LIST);
  }

}
