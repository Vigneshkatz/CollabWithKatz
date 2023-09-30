import { Observable, map, of, switchMap } from 'rxjs';
import { BackendService } from './../backend/backend.service';
import { Injectable } from '@angular/core';
import { Creator } from 'src/app/common/creator/creator';

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
  addCreator(creator: Creator) {
    this.backendService.addCreator(creator).subscribe(
      (creatorDetails: Creator) => {
        console.log(creatorDetails);
      },
      (error: any) => {
        console.error('Error fetching creator details:', error);
      }
    );
  }

  loginCreator(user_email: string, user_password: string):Observable<boolean> {
    if (!user_email || !user_password || user_email.trim() === '' || user_password.trim() === '') {
      return of(false); 
    }


    return this.backendService.creatorLogin(user_email, user_password).pipe(
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

}
