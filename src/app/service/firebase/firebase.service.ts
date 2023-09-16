import { Injectable } from '@angular/core';
import { AngularFireStorage } from '@angular/fire/compat/storage';
import { AngularFireUploadTask } from '@angular/fire/compat/storage';
import { finalize } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FirebaseService {
  title = 'fileupload';
  task!: AngularFireUploadTask; 
  downloadUrl:string="";

  constructor(private storage: AngularFireStorage) { }

  uploadFileToFireBase(event: any):string {
    console.log("FirebaseService")
    const file = event.target.files[0];
    if (file) {
      const filePath = `/uploads/${file.name}`;
      const fileRef = this.storage.ref(filePath);
      this.task = this.storage.upload(filePath, file);

      this.task.snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(downloadURL => {
            this.downloadUrl=downloadURL;
          });
        })
      ).subscribe();
    }
    return this.downloadUrl;
  }
}


