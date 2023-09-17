import { Component, NgModule } from '@angular/core';
import { EditorService } from 'src/app/service/editor/editor.service';
@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrls: ['./profilepage.component.css']
})
export class ProfilepageComponent {

  myProfile:any={};

  constructor(private editorService:EditorService)
  {

  }
  ngOnInit() {
    const editor_id = 2;
      // this.editorService.getEditorInfo(editor_id)
      this.editorService.getEditorInfo(editor_id)
      .subscribe((data: any) => {
        this.myProfile = data; // Assign the fetched data to myProfile
        console.log(this.myProfile.name); // Now you can safely access myProfile properties
      });
  
  }
  
}
