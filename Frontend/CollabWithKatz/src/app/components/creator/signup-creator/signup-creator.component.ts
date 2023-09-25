import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {Creator} from '../../../common/creator/creator'
import { CreatorService } from 'src/app/service/creator/creator.service';
@Component({
  selector: 'app-signup-creator',
  templateUrl: './signup-creator.component.html',
  styleUrls: ['./signup-creator.component.css']
})
export class SignupCreatorComponent {


  formData: any = {};
  creator:Creator = new Creator();

  constructor(private router: Router, private creatorService: CreatorService) { }

  onSubmit() {
    this.checkPassword();
  }

  setcreator(): void {
    this.creator.id = 0;
    this.creator.name = this.formData.name;
    this.creator.email = this.formData.email;
    this.creator.password = this.formData.password;
    this.creator.reviewList = [];
    this.creator.upvoteList=[]
    console.log(this.creator);
  }

  checkPassword(): boolean {
    const password = this.formData.password;
    const confirm_password = this.formData.confirm_password;
    if (password && confirm_password && password == confirm_password) {
      console.log("Password matchs");
      this.setcreator();
      this.creatorService.addCreator(this.creator);
      this.router.navigate(['creator/home']);
      return true;
    }
    console.log("Password does not match");
    this.router.navigate(['/error']);
    return false;
  }
}
