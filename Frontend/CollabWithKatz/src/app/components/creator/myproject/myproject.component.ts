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

    try {
      const data: any[] = await this.projectService.projectByCreatorId(1).toPromise();
      this.projectList = data;
      console.log(data);
    } catch (error) {
      console.error(error);
    }

    console.log(this.projectList);
  }

  logout(){
    this.router.navigate(['/login']);
  }
}
