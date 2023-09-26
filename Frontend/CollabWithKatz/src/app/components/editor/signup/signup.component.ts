import { Component } from '@angular/core';
import { Editor } from 'src/app/common/editor/editor';
import { Router } from '@angular/router';
import { EditorService } from 'src/app/service/editor/editor.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent {
  formData: any = {};
  editor: Editor = new Editor();

  constructor(private router: Router, private editorService: EditorService) { }

  onSubmit() {
    this.checkPassword();
  }

  setEditor(): void {
    this.editor.id = 0;
    this.editor.name = this.formData.name;
    this.editor.email = this.formData.email;
    this.editor.password = this.formData.password;
    this.editor.age = this.formData.age;
    this.editor.country = this.formData.country;
    this.editor.gender = this.formData.gender;
    this.editor.experienceInYears = this.formData.experienceInYears;
    this.editor.profilePictureUrl = "profileLink";
    this.editor.phone = this.formData.phone;
    this.editor.portfolioLink = "portfoliolink"
    this.editor.profileCreatedAt = new Date();
    this.editor.ProfileUpdatedAt = new Date();
    this.editor.editorCertifications = [];
    this.editor.editorCommunicationLanguages = []
    this.editor.editorPreferences = []
    this.editor.editorProjects = []
    this.editor.editorSampleVideos = []
    this.editor.editorSocialMedia = []
    this.editor.editorSkills = []
    console.log(this.editor);
  }

  checkPassword(): boolean {
    const password = this.formData.password;
    const confirm_password = this.formData.confirm_password;
    if (password && confirm_password && password == confirm_password) {
      console.log("Password matchs");
      this.setEditor();
      this.editorService.registerEditor(this.editor).then(editorId => {
        console.log(editorId);
        this.router.navigate([`/editor/home/${editorId}`]);
      })
        .catch(error => {
         console.log(error)
        });;
      return true;
    }
    console.log("Password does not match");
    this.router.navigate(['/error']);
    return false;
  }
}
