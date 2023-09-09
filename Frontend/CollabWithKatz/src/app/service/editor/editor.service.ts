import { Injectable } from '@angular/core';
import { BackendService } from '../backend/backend.service';
import { Observable, map, of, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EditorService {

  constructor(private backend: BackendService) { }

  isValidUserLogin(user_email: string, user_password: string): Observable<boolean> {
    if (!user_email || !user_password || user_email.trim() === '' || user_password.trim() === '') {
      return of(false); // Invalid input, return Observable of false
    }
  
    // If input is valid, call the login method and return the result as an Observable
    return this.backend.login(user_email,user_password).pipe(
      map((isValid: boolean) => isValid),
      switchMap((isValid: boolean) => {
        if (isValid) {
          return of(true); // Valid user, return Observable of true
        } else {
          return of(false); // Invalid user, return Observable of false
        }
      })
    );
  }

  // login

  // registor

  // fileupload

  // 
}
