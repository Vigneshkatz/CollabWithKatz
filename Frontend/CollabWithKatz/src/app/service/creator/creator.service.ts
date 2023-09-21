import { Observable } from 'rxjs';
import { BackendService } from './../backend/backend.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreatorService {


  editorList: any = []

  constructor(private backendService: BackendService) { }

  getAllEditor(): Promise<any[]> {
    return new Promise((resolve, reject) => {
      this.backendService.getAllEditor()
        .subscribe(
          (data: any) => {
            resolve(data);
            console.log(data);
          },
          (error: any) => {
            console.error(error);
            reject(error); 
          }
        );
    });
  }

  sortEditorBy(sortValue: string): Promise<any[]> {
    throw new Error('Method not implemented.');
  }
}
