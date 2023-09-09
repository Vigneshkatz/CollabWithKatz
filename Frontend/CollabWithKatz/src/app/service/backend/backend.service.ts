import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, map, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private BASEURL:string = 'http://localhost:8000';


  constructor(private http: HttpClient) { }

  // login
  login(user_email:string,user_password :string): Observable<boolean>{
   // http://localhost:8000/v1/editor/byEmail?email=vignesh000129%40gmail.com
    const LOGIN_URL = `${this.BASEURL}/v1/editor/byEmail?email=${user_email}&password=${user_password}`;
    return this.http.get(LOGIN_URL).pipe(
      map((response) => {
        
        console.log('Response:', response);
        return true;
      }),
      catchError((error) => {
        // Handle any errors here and return false
        console.error('Error:', error);
        return of (false);
      })
    );
  }

  // register

}
