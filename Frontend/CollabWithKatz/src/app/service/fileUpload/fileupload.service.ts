import { FirebaseService } from './../firebase/firebase.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FileuploadService {

  constructor(private firebaseService: FirebaseService) { }

  async uploadVideo(event: any): Promise<string> {
    console.log("FileuploadService");
    try {
      const downloadUrl = await this.firebaseService.uploadFileToFireBase(event);
      console.log(downloadUrl);
      return downloadUrl;

    } catch (error) {
      console.error('Error uploading video:', error);
      return "File not Uploaded";

    }
  }

  async uploadFile(event: any): Promise<string> {
    console.log("FileuploadService");
    try {
      const downloadUrl = await this.firebaseService.uploadFileToFireBase(event);
      return downloadUrl;
    } catch (error) {
      console.error('Error uploading file:', error);
      throw error;
    }
  }


}
