import { Injectable } from '@angular/core';
import { BackendService } from '../backend/backend.service';
import { Observable, map, of, switchMap } from 'rxjs';
import { Editor } from 'src/app/common/editor/editor';

@Injectable({
  providedIn: 'root'
})
export class EditorService {

  constructor(private backend: BackendService) { }

  isValidUserLogin(editor_email: string, editor_password: string): Observable<boolean> {
    if (!editor_email || !editor_password || editor_email.trim() === '' || editor_password.trim() === '') {
      return of(false); // Invalid input, return Observable of false
    }
  
    // If input is valid, call the login method and return the result as an Observable
    return this.backend.login(editor_email,editor_password).pipe(
      map((isValid: boolean) => isValid),
      switchMap((isValid: boolean) => {
        if (isValid) {
          return of(true); // Valid editor, return Observable of true
        } else {
          return of(false); // Invalid editor, return Observable of false
        }
      })
    );
  }

  registerEditor(editor:Editor):void{
    console.log("signup editor editorservice");

    this.backend.signUp(editor);
  }
}
