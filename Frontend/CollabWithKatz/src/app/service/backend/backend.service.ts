import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, of, throwError } from 'rxjs';
import { Editor } from 'src/app/common/editor/editor';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private BASEURL: string = 'http://localhost:8000/v1/editors';

  constructor(private http: HttpClient) { }

  // login
  login(editor_email: string, editor_password: string): Observable<boolean> {
    const LOGIN_URL = `${this.BASEURL}/byEmail?email=${editor_email}&password=${editor_password}`;
    return this.http.get(LOGIN_URL).pipe(
      map((response) => {

        console.log('Response:', response);
        return true;
      }),
      catchError((error) => {
        console.error('Error:', error);
        return of(false);
      })
    );
  }

  // register

  signUp(editor: Editor): Observable<boolean> {
    console.log("signup editor backend");
    const SIGN_UP_URL = `${this.BASEURL}/addEditor`;
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    console.log(this.http.post(SIGN_UP_URL, editor));
    return this.http.post(SIGN_UP_URL, editor).pipe(
      map((response) => {
        console.log('Response:', response);
        return true;
      }),
      catchError((error) => {
        console.error('Error:', error);
        return of(false);
      })
    );
  }
  // get editor by email
  getEditorByEditorId(editor_id: number): Observable<any> {
    console.log("signup editor backend");
    const GET_EDITOR_DETAIL_BY_ID_URL = `${this.BASEURL}/editorById?id=${editor_id}`;
    return this.http.get<any>(GET_EDITOR_DETAIL_BY_ID_URL);

  }

  // Creator section

  getAllEditor(): any {
    const GET_ALL_EDITOR = `http://localhost:8000/v1/editors/allEditors`;
    return this.http.get(GET_ALL_EDITOR);
    
  }

}
