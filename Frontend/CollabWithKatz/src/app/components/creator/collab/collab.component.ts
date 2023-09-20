import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Project } from 'src/app/common/project/project';
import { FileuploadService } from 'src/app/service/fileUpload/fileupload.service';
import { ProjectService } from 'src/app/service/project/project.service';

@Component({
  selector: 'app-collab',
  templateUrl: './collab.component.html',
  styleUrls: ['./collab.component.css']
})
export class CollabComponent implements OnInit {
  selectedVideo: File | null = null;
  formDetails: {
    projectId: number;
    projectName: string;
    projectDescription: string;
    rawVideoURl: string;
    editedVideoURL: string;
    creatorId: number;
    editorId: number;
  } = {
      projectId: 0,
      projectName: '',
      projectDescription: '',
      rawVideoURl: '',
      editedVideoURL: '',
      editorId: 0,
      creatorId: 0
    };

  creatorId: number = 0;
  editorId: number = 0;
  isDTOCreated: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private fileuploadService: FileuploadService,
    private projectService: ProjectService,
    private project: Project
  ) { }

  ngOnInit() {
    this.initializeComponent();
  }

  private initializeComponent() {
    this.route.params.subscribe(params => {
      this.creatorId = +params['creatorId'];
      this.editorId = +params['editorId'];
      this.project.creatorId = this.creatorId;
      this.project.editorId = this.editorId;
    });
  }

  async uploadFile(event: any) {
    try {
      const downloadURL = await this.fileuploadService.uploadVideo(event);
      this.isDTOCreated = true;
      this.project.rawVideoURl = downloadURL;
      if (this.isDTOCreated) {
        this.projectService.addProject(this.project).subscribe((data: any) => {
          console.log(data);
        });;
      }
    } catch (error) {
      console.error('Error uploading video:', error);
    }
  }

  onSubmit() {
    this.project.id = 0;
    this.project.projectName = this.formDetails.projectName;
    this.project.projectDescription = this.formDetails.projectDescription;
  }
}
