import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';

@Component({
  selector: 'app-collab',
  templateUrl: './collab.component.html',
  styleUrls: ['./collab.component.css']
})
export class CollabComponent {

  constructor(private creatorService:CreatorService, private route: ActivatedRoute) {
        this.route.params.subscribe(params => {
          const creatorId = +params['creatorId'];
          const editorId = +params['editorId'];
        console.log(creatorId,editorId);
      });
  }

  ngOnInit(){

  }

}
