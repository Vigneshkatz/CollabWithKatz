import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/editor/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FileuploadComponent } from './components/fileupload/fileupload.component';
import { SignupComponent } from './components/editor/signup/signup.component';
import { FormsModule } from '@angular/forms';

import { AngularFireModule } from '@angular/fire/compat';
import { AngularFireStorageModule } from '@angular/fire/compat/storage';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { ProfilepageComponent } from './components/editor/profilepage/profilepage.component';
import { ErrorPageComponent } from './components/error-page/error-page.component';
import { CreatorHomeComponent } from './components/creator/creator-home/creator-home.component';
import { CollabComponent } from './components/creator/collab/collab.component';
import { SignupCreatorComponent } from './components/creator/signup-creator/signup-creator.component';
import { MyprojectComponent } from './components/creator/myproject/myproject.component';
import { MyprojectsComponent } from './components/editor/myprojects/myprojects.component';
import { Project } from './common/project/project'; // Import the Project service

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    FileuploadComponent,
    SignupComponent,
    LandingpageComponent,
    ProfilepageComponent,
    ErrorPageComponent,
    CreatorHomeComponent,
    CollabComponent,
    SignupCreatorComponent,
    MyprojectComponent,
    MyprojectsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyBuLKnFnb9ZZJBgZDKG7jv9X4P1qYYPA4A",
      authDomain: "collabwithkatz.firebaseapp.com",
      projectId: "collabwithkatz",
      storageBucket: "collabwithkatz.appspot.com",
      messagingSenderId: "570440142532",
      appId: "1:570440142532:web:39fee0b6507d27f8460391",
      measurementId: "G-DRJPZ22CDS"
    }),
    AngularFireStorageModule,
    HttpClientModule,
  ],
  providers: [
    Project,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
