import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, of, throwError } from 'rxjs';
import { Editor } from 'src/app/common/editor/editor';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private BASEURL: string = 'http://localhost:8000';


  constructor(private http: HttpClient) { }

  // login
  login(editor_email: string, editor_password: string): Observable<boolean> {
    // http://localhost:8000/v1/editor/byEmail?email=vignesh000129%40gmail.com
    const LOGIN_URL = `${this.BASEURL}/v1/editor/byEmail?email=${editor_email}&password=${editor_password}`;
    return this.http.get(LOGIN_URL).pipe(
      map((response) => {

        console.log('Response:', response);
        return true;
      }),
      catchError((error) => {
        // Handle any errors here and return false
        console.error('Error:', error);
        return of(false);
      })
    );
  }

  // register

  signUp(editor: Editor): Observable<boolean> {
    console.log("signup editor backend");
    const SIGN_UP_URL = `${this.BASEURL}/v1/editor/addEditor`;
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
    // http://localhost:8000/v1/editor/editorById?id=1
    console.log("signup editor backend");
    const GET_EDITOR_DETAIL_BY_ID_URL = `${this.BASEURL}/v1/editor/editorById?id=${editor_id}`;
    return this.http.get<any>(GET_EDITOR_DETAIL_BY_ID_URL);

  }

}
