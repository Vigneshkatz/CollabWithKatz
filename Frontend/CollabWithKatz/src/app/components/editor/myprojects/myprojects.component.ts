import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectService } from 'src/app/service/project/project.service';

@Component({
  selector: 'app-myprojects',
  templateUrl: './myprojects.component.html',
  styleUrls: ['./myprojects.component.css']
})
export class MyprojectsComponent implements OnInit {
  projectList: any[] = [];

  constructor(private projectService: ProjectService, private router: Router) {}

  ngOnInit() {
    console.log("My project");
    
    this.projectService.projectByEditorId(1)
      .subscribe(
        (data: any) => {
          this.projectList = data;
          console.log(data);
          console.log(this.projectList);
        },
        (error: any) => {
          console.error(error);
          this.router.navigate(['/error']);
        }
      );
  }

  logout() {
    this.router.navigate(['/login']);
  }
}
