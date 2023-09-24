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

  constructor(private storage: AngularFireStorage) { }

  uploadFileToFireBase(event: any): Promise<string> {
    return new Promise((resolve, reject) => {
      const file = event.target.files[0];
      if (!file) {
        reject('No file selected');
        return;
      }

      const filePath = `/uploads/${file.name}`;
      const fileRef = this.storage.ref(filePath);
      this.task = this.storage.upload(filePath, file);

      this.task.snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(downloadURL => {
            if (downloadURL) {
              resolve(downloadURL);
            } else {
              reject('Failed to get download URL');
            }
          }, error => {
            reject(error);
          });
        })
      ).subscribe();
    });
  }
}
