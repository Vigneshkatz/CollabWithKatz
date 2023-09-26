import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { CreatorService } from 'src/app/service/creator/creator.service';
import { EditorService } from 'src/app/service/editor/editor.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  isCreator:boolean = true;

    constructor(private editorService:EditorService,private router:Router,private creatorService:CreatorService){
      console.log(this.isCreator);
    }

    fetchFormValue(user_email: string,user_password: string):void {
      console.log(user_email);
      console.log(user_password);
      if(this.isCreator)
      {
        this.loginCreator(user_email,user_password);
      }else{
        this.loginEditor(user_email,user_password);
      }
    }
  loginEditor(user_email:string,user_password:string) {
    const isValidUser = this.editorService.isValidUserLogin(user_email,user_password);
    isValidUser.subscribe((value: boolean) => {
      if (value === true) {
        this.router.navigate(['/editor/home/1']);
      } else {
        this.router.navigate(['/welcome']);
      }
    });
  }
  loginCreator(user_email:string,user_password:string) {
    const isValidCreator = this.creatorService.loginCreator(user_email,user_password);
    isValidCreator.subscribe((value: boolean) => {
      if (value === true) {
        this.router.navigate(['creator/home']);
      } else {
        this.router.navigate(['/welcome']);
      }
    });
  }

    changeLoginType(){
        this.isCreator = !this.isCreator;
    }
    
    redirectToSignUp(){
      console.log(this.isCreator);
      if(this.isCreator)
      {
        this.router.navigate(['/creator/signup']);
      }else{
        this.router.navigate(['/editor/signup']);

      }
    }
}
