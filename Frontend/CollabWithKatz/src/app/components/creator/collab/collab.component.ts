import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';
import { FileuploadService } from 'src/app/service/fileUpload/fileupload.service';

@Component({
  selector: 'app-collab',
  templateUrl: './collab.component.html',
  styleUrls: ['./collab.component.css']
})
export class CollabComponent {
  
  selectedVideo: File | null = null;
  formDetails: {
    email: string;
    name: string;
    message: string;
  } = { email: '', name: '', message: '' };
  constructor(private creatorService:CreatorService, 
    private route: ActivatedRoute,
    private fileuploadService:FileuploadService) {
        this.route.params.subscribe(params => {
          const creatorId = +params['creatorId'];
          const editorId = +params['editorId'];
        console.log(creatorId,editorId);
      });
  }

  ngOnInit(){

  }
  uploadFile(event: any) {
    console.log("fileUpload.ts")
    this.fileuploadService.uploadVideo(event);
  }

  onFileChange(event: any) {
    if (event.target.files && event.target.files.length > 0) {
      this.selectedVideo = event.target.files[0];
    }
  }
  onSubmit() {
    this.formDetails.email = this.formDetails.email;
    this.formDetails.name = this.formDetails.name; 
    this.formDetails.message = this.formDetails.message;
    console.log(this.formDetails);
  }

}
