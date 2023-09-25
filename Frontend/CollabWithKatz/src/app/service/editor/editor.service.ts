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
      return of(false); 
    }


    return this.backend.login(editor_email, editor_password).pipe(
      map((isValid: boolean) => isValid),
      switchMap((isValid: boolean) => {
        if (isValid) {
          return of(true);
        } else {
          return of(false);
        }
      })
    );
  }

  registerEditor(editor: Editor): Promise<number> {
    return new Promise<number>((resolve, reject) => {
      console.log("signup editor editorservice");
  
      this.backend.signUp(editor).subscribe(
        (editor: Editor) => {
          resolve(editor.id);
        },
        (error: any) => {
          console.error('Error fetching Editor details:', error);
          reject(error);
        }
      );
    });
  }
  

  // get Editor information\

  getEditorInfo(editor_id: number): Observable<any> {
    return this.backend.getEditorByEditorId(editor_id);
  }
}
