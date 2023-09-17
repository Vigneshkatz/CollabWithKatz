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
    projectId:number;
    projectName: string;
    projectDescription: string;
    rawVideoURl: string,
    editedVideoURL: string,
    creatorId: number,
    editorId: number
  } = { projectId:0, projectName: '', projectDescription: '', rawVideoURl: '', editedVideoURL: '', editorId: 0, creatorId: 0 };

  creatorId: number = 0;
  editorId: number = 0;

  constructor(private creatorService: CreatorService,
    private route: ActivatedRoute,
    private fileuploadService: FileuploadService) {
    this.route.params.subscribe(params => {
      this.creatorId = +params['creatorId'];
      this.editorId = +params['editorId'];
    });
  }

  ngOnInit() {

  }
  async uploadFile(event: any) {
    console.log("fileUpload.ts")
    console.log(event.target.files);
    try {
      const downloadURL = await this.fileuploadService.uploadVideo(event);
      console.log(downloadURL);
      this.formDetails.rawVideoURl = downloadURL;
    } catch (error) {
      console.error('Error uploading video:', error);
    }
  }

  onSubmit() {
    this.formDetails.projectName = this.formDetails.projectName;
    this.formDetails.projectDescription = this.formDetails.projectDescription;
    this.formDetails.creatorId = this.creatorId;
    this.formDetails.editorId = this.editorId;
    console.log(this.formDetails);
  }

}
