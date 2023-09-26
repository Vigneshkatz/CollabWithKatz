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

  registerEditor(editor: Editor): number {
    let editorId:number = 0;
    this.backend.signUp(editor)
    .subscribe(
      (editorDetails: Editor) => {
        console.log(editorDetails);
        editorId = editorDetails.id;
        // return editorId;
      },
      (error: any) => {
        console.error('Error fetching editor details:', error);
      }
    );
    return editorId;
  }
  
  // get Editor information\

  getEditorInfo(editor_id: number): Observable<any> {
    return this.backend.getEditorByEditorId(editor_id);
  }
}
