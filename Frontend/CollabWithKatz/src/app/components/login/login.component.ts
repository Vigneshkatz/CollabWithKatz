import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { EditorService } from 'src/app/service/editor/editor.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

    constructor(private editoService:EditorService,private router:Router){
    }

    fetchFormValue(user_email: string,user_password: string):void {
      console.log(user_email);
      console.log(user_password);
      const isValidUser = this.editoService.isValidUserLogin(user_email,user_password);
      isValidUser.subscribe((value: boolean) => {
        if (value === true) {
          this.router.navigate(['/home']);
        } else {
          this.router.navigate(['/welcome']);
        }
      });
    }
}
