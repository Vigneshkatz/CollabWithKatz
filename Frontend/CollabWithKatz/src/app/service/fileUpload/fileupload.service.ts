import { FirebaseService } from './../firebase/firebase.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FileuploadService {

  constructor(private firebaseService:FirebaseService) { }

  uploadVideo(event: any) {
    console.log("FileuploadService")
    const downloadUrl = this.firebaseService.uploadFileToFireBase(event);
    console.log(downloadUrl);
  }
}
