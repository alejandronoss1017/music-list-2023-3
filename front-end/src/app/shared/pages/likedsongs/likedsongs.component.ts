import { Component } from '@angular/core';

@Component({
  selector: 'app-likedsongs',
  templateUrl: './likedsongs.component.html',
  styleUrls: ['./likedsongs.component.css']
})
export class LikedsongsComponent {
    musicList = [
  { title: 'Cancion1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
  { title: 'Song Title 1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
  { title: 'Song Title 2', artist: 'Artist Name 2', duration: '3:45', album: 'Album Name 2' },
  { title: 'Another Song', artist: 'Another Artist', duration: '3:15', album: 'Another Album' },
  { title: 'Hit Song', artist: 'Famous Artist', duration: '2:50', album: 'Greatest Hits' },
  { title: 'Cool Tune', artist: 'Cool Artist', duration: '3:10', album: 'Cool Album' },
  { title: 'Jazz Groove', artist: 'Jazz Ensemble', duration: '5:30', album: 'Smooth Jazz' },
  { title: 'Rock Anthem', artist: 'Rock Band', duration: '4:15', album: 'Rock Classics' },
  { title: 'Dance Beat', artist: 'DJ Mixmaster', duration: '4:00', album: 'Club Hits' },
  { title: 'Country Ballad', artist: 'Country Singer', duration: '3:55', album: 'Country Stories' },
  { title: 'Rap Rhymes', artist: 'Rapper MC', duration: '3:30', album: 'Hip-Hop Evolution' },
  ];

  
  favoriteStates: boolean[] = new Array(this.musicList.length).fill(false);

  toggleHeartColor(index: number) {
    this.favoriteStates[index] = !this.favoriteStates[index];
  }
  
}
