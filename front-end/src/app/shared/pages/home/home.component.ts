import { Component } from '@angular/core';

@Component({
  selector: 'shared-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  musicList = [
    { title: 'Song Title 1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
    { title: 'Song Title 2', artist: 'Artist Name 2', duration: '3:45', album: 'Album Name 2' },
    // Add more music items as needed
  ];
}
