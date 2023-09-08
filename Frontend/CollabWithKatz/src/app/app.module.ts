import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FileuploadComponent } from './components/fileupload/fileupload.component';
import { SignupComponent } from './components/signup/signup.component';
import { FormsModule } from '@angular/forms';

import { AngularFireModule } from '@angular/fire/compat';
import { AngularFireStorageModule } from '@angular/fire/compat/storage';
import { LandingpageComponent } from './components/landingpage/landingpage.component'; // Import AngularFireStorageModule

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    FileuploadComponent,
    SignupComponent,
    LandingpageComponent
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
    AngularFireStorageModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
