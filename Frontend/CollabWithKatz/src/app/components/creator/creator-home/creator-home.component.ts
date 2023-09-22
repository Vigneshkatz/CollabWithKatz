import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';

@Component({
  selector: 'app-creator-home',
  templateUrl: './creator-home.component.html',
  styleUrls: ['./creator-home.component.css']
})
export class CreatorHomeComponent {
  editorList: any[] = [];
  sortValue: string = '';
  isChatVisible: boolean = true;
  constructor(private creatorService: CreatorService, private router: Router) {

  }

  ngOnInit() {
    this.creatorService.getAllEditor()
      .then((data: any[]) => {
        this.editorList = data;
        this.executeAfterHTTP();
      })
      .catch((error) => {
        console.error(error);
      });
    console.log(this.editorList);
  }

  executeAfterHTTP() {
    console.log("Code executed after HTTP request:", this.editorList);
  }

  onCollab() {
    const creatorId = 1;
    const editorId = 1;
    console.log('onCollab() function called');
    this.router.navigate(['/creator/collab', creatorId, editorId]);
  }


  logout() {
    this.router.navigate(['/login']);
  }

  sortBy() {
    this.creatorService.sortEditorBy(this.sortValue).then((data: any[]) => {
      this.editorList = data;
      this.executeAfterHTTP();
    })
      .catch((error: any) => {
        console.error(error);
        this.router.navigate(['/error']);
      });
    console.log(this.editorList);

  }

  viewProfile(editorId:number){
    this.router.navigate(['/profilePage',editorId]);
  }

  toggleChat() {
    this.isChatVisible = !this.isChatVisible;
  }

}
