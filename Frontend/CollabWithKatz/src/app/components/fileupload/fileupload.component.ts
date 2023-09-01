import { Component } from '@angular/core';

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent {
  selectedVideo: File | null = null;

  onFileChange(event: any) {
    this.selectedVideo = event.target.files[0];
  }

  uploadVideo() {
    if (this.selectedVideo) {
      // Implement your file upload logic here
      // You can use HttpClient to send the file to your backend server
      console.log('Uploading video:', this.selectedVideo.name);
    }
  }
}
