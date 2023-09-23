import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { HomeComponent } from './components/editor/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FileuploadComponent } from './components/fileupload/fileupload.component';
import { SignupComponent } from './components/editor/signup/signup.component';
import { ProfilepageComponent } from './components/editor/profilepage/profilepage.component'; 
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { CreatorHomeComponent } from './components/creator/creator-home/creator-home.component';
import { CollabComponent } from './components/creator/collab/collab.component';
import { SignupCreatorComponent } from './components/creator/signup-creator/signup-creator.component';
import { MyprojectComponent } from './components/creator/myproject/myproject.component';
import { MyprojectsComponent } from './components/editor/myprojects/myprojects.component';
import { ChatComponent } from './components/chat/chat.component';


const routes: Routes = [
  { path: 'welcome', component: LandingpageComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'fileupload', component: FileuploadComponent },
  { path: 'editor/signup', component: SignupComponent },
  { path: 'error', component: ErrorPageComponent },
  { path: 'profilePage/:editorId', component: ProfilepageComponent },
  { path: 'creator/home', component: CreatorHomeComponent },
  { path: 'creator/signup', component:  SignupCreatorComponent},
  { path: 'creator/myproject', component: MyprojectComponent },
  { path: 'editor/myproject', component: MyprojectsComponent },
  { path: 'creator/collab/:creatorId/:editorId', component: CollabComponent },
  { path: 'chat', component: ChatComponent },
  { path: '**', component: LandingpageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
