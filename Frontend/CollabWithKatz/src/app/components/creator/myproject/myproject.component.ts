import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';
import { FileuploadService } from 'src/app/service/fileUpload/fileupload.service';

@Component({
  selector: 'app-myproject',
  templateUrl: './myproject.component.html',
  styleUrls: ['./myproject.component.css']
})
export class MyprojectComponent {

  projectList:any={};
  constructor(private creatorService: CreatorService,private router:Router) {

  }

  ngOnInit(){

  }

  logout(){
    this.router.navigate(['/login']);
  }
}
