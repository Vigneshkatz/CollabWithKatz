import { Injectable } from '@angular/core';
import { BackendService } from '../backend/backend.service';
import { Observable } from 'rxjs';
import { Project } from 'src/app/common/project/project';
// import { Project } from 'src/app/common/project/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private backendService: BackendService) { }

  addProject(project: Project) :Observable<any>{
    console.log(project);
    const response  =  this.backendService.addProject(project);
    console.log(response);
    return response;
  }

  projectByCreatorId(creatorId: number): Observable<any> {
    return this.backendService.projectByCreatorId(creatorId);
  }

  projectByEditorId(editorId: number): Observable<any> {
    return this.backendService.getProjectByEditorId(editorId);
  }
}
