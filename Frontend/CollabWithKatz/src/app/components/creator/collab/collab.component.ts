import { Component } from '@angular/core';
import { CreatorService } from 'src/app/service/creator/creator.service';

@Component({
  selector: 'app-collab',
  templateUrl: './collab.component.html',
  styleUrls: ['./collab.component.css']
})
export class CollabComponent {

  constructor(private creatorService:CreatorService)
  {

  }

  ngOnInit(){

  }

}
