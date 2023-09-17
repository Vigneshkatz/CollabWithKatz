import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';

@Component({
  selector: 'app-myprojects',
  templateUrl: './myprojects.component.html',
  styleUrls: ['./myprojects.component.css']
})
export class MyprojectsComponent {
  projectList:any={};
  constructor(private creatorService: CreatorService,private router:Router) {

  }

  ngOnInit(){

  }

  logout(){
    this.router.navigate(['/login']);
  }
}

