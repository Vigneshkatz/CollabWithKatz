import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FileuploadComponent } from './components/fileupload/fileupload.component';
import { SignupComponent } from './components/signup/signup.component';
import { ProfilepageComponent } from './components/profilepage/profilepage.component'; 
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { CreatorHomeComponent } from './components/creator/creator-home/creator-home.component';
import { CollabComponent } from './components/creator/collab/collab.component';

const routes: Routes = [
  { path: 'welcome', component: LandingpageComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'fileupload', component: FileuploadComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'error-page', component: ErrorPageComponent },
  { path: 'profilePage', component: ProfilepageComponent },
  { path: 'creator', component: CreatorHomeComponent },
  { path: 'creator/collab', component: CollabComponent },
  { path: '**', component: LandingpageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
