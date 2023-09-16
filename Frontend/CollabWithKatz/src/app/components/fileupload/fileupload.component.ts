import { FileuploadService } from './../../service/fileUpload/fileupload.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-fileupload',
  templateUrl: './fileupload.component.html',
  styleUrls: ['./fileupload.component.css']
})
export class FileuploadComponent {
  selectedVideo: File | null = null;

  constructor(private fileuploadService:FileuploadService){

  }

  uploadFile(event: any) {
    console.log("fileUpload.ts")
    this.fileuploadService.uploadVideo(event);
  }
}
