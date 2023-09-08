import { Component } from '@angular/core';
import { Editor } from 'src/app/common/editor/editor';
import { Router } from '@angular/router';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  formData: any = {}; 
  editor: Editor = new Editor();

  constructor(private router: Router) { }

  
  onSubmit() {
    this.editor.name = this.formData.name;
    this.editor.email= this.formData.email;
    this.editor.password= this.formData.password;
    this.editor.age = this.formData.age;
    this.editor.country = this.formData.country;
    this.editor.gender = this.formData.gender;
    this.editor.experienceInYears = this.formData.experience;
    this.editor.phone= this.formData.phone;
    this.editor.language = this.formData.preferred_language;
    this.editor.preferences = this.formData.preferences; 
    console.log(this.editor);
    this.router.navigate(['/home']);
  }

}
