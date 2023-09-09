import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FileuploadComponent } from './components/fileupload/fileupload.component';
import { SignupComponent } from './components/signup/signup.component';
import { ProfilepageComponent } from './components/profilepage/profilepage.component'; // Import AngularFireStorageModule


const routes: Routes = [
  { path: 'welcome', component: LandingpageComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'fileupload', component: FileuploadComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'profilePage', component: ProfilepageComponent },
  { path: '**', component: LandingpageComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
