import { Component, NgModule } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EditorService } from 'src/app/service/editor/editor.service';
@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrls: ['./profilepage.component.css']
})
export class ProfilepageComponent {

  myProfile:any={};
  editorId:number=0;

  constructor(private editorService:EditorService,
    private route: ActivatedRoute,
    private router:Router)
  {
    this.route.paramMap.subscribe(params => {
      const editorId = params.get('editorId'); 
  
      if (editorId !== null  && editorId !== undefined) {
        this.editorId=+editorId;
      } else {
        this.router.navigate(['/error']);
      }
    });

  }
  ngOnInit() {
      this.editorService.getEditorInfo(this.editorId)
      .subscribe((data: any) => {
        this.myProfile = data;
        console.log(this.myProfile.name);
      });
  
  }
  
}
