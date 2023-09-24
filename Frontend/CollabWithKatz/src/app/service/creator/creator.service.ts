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
    console.log(`${sortValue} creator service` );
    return new Promise((resolve, reject) => {
      this.backendService.sortEditorsBy(sortValue)
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

  getCreator(creatorId: number) :string{
    let creatorName ='';
    console.log(creatorId);
    this.backendService.getCreatorDetail(creatorId).subscribe(
      (creatorDetails: any) => {
        console.log(creatorDetails);
        if (creatorDetails && creatorDetails.name) {
          creatorName=creatorDetails.name;
        } else {
          console.error('Creator details or name is null or undefined.');
        }
      },
      (error: any) => {
        console.error('Error fetching creator details:', error);
      }
    );
    return creatorName;
  }

}
