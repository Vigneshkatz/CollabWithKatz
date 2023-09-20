import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';
import { FileuploadService } from 'src/app/service/fileUpload/fileupload.service';
import { ProjectService } from 'src/app/service/project/project.service';

@Component({
  selector: 'app-myproject',
  templateUrl: './myproject.component.html',
  styleUrls: ['./myproject.component.css']
})
export class MyprojectComponent {
  projectList:any[] = [];

  constructor(private projectService: ProjectService,private router:Router) {

  }


  async ngOnInit() {
    console.log("My project");

    this.projectService.projectByCreatorId(1)
    .subscribe(
      (data: any) => {
        this.projectList = data;
        console.log(data);
        console.log(this.projectList); // Move it here to log the updated data
      },
      (error: any) => {
        console.error(error);
        // Handle the error, e.g., display an error message to the user
      }
    );
  }

  logout(){
    this.router.navigate(['/login']);
  }
}
