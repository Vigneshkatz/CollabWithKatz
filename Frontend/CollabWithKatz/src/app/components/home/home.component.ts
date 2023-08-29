import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {// Replace with actual video path
  videoSources = [
    '../../../assets/cat_demo.mp4',
    '../../../assets/cat_demo.mp4',
    '../../../assets/cat_demo.mp4'
    // Add more video sources as needed
  ];
  playVideo(video: HTMLVideoElement) {
    video.play();
  }

  pauseVideo(video: HTMLVideoElement) {
    video.pause();
    video.currentTime = 0;
  }
  
}
