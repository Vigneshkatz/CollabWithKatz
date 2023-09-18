import { Injectable } from '@angular/core';
import { BackendService } from '../backend/backend.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private backendService:BackendService) { }

  projectByCreatorId(creatorId:number):Observable<any>{
    return this.backendService.projectByCreatorId(creatorId);
  }

  projectByEditorId(editorId:number):Observable<any>{
    return this.backendService.getProjectByEditorId(editorId);
  }
}
