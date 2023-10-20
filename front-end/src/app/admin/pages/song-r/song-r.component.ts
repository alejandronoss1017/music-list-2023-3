import { Component } from '@angular/core';

@Component({
  selector: 'app-song-r',
  templateUrl: './song-r.component.html',
  styleUrls: ['./song-r.component.css']
})
export class SongRComponent {
  songId: string = ''; 
  musicList = [
  { title: 'Song Title 1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' }]
}
