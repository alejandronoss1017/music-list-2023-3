import { Component } from '@angular/core';
import { Song } from 'src/types/Song';


@Component({
  selector: 'shared-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  musicList: Song[] = [
    {
      title: 'Song Title 1',
      artist: 'Artist Name 1',
      duration: '4:20',
      album: 'Album Name 1',
      favorite: false,
    },
    {
      title: 'Song Title 2',
      artist: 'Artist Name 2',
      duration: '3:45',
      album: 'Album Name 2',
      favorite: false,
    },
    {
      title: 'Another Song',
      artist: 'Another Artist',
      duration: '3:15',
      album: 'Another Album',
      favorite: false,
    },
    {
      title: 'Hit Song',
      artist: 'Famous Artist',
      duration: '2:50',
      album: 'Greatest Hits',
      favorite: false,
    },
    {
      title: 'Cool Tune',
      artist: 'Cool Artist',
      duration: '3:10',
      album: 'Cool Album',
      favorite: false,
    },
    {
      title: 'Jazz Groove',
      artist: 'Jazz Ensemble',
      duration: '5:30',
      album: 'Smooth Jazz',
      favorite: false,
    },
    {
      title: 'Rock Anthem',
      artist: 'Rock Band',
      duration: '4:15',
      album: 'Rock Classics',
      favorite: false,
    },
    {
      title: 'Dance Beat',
      artist: 'DJ Mixmaster',
      duration: '4:00',
      album: 'Club Hits',
      favorite: false,
    },
    {
      title: 'Country Ballad',
      artist: 'Country Singer',
      duration: '3:55',
      album: 'Country Stories',
      favorite: false,
    },
    {
      title: 'Rap Rhymes',
      artist: 'Rapper MC',
      duration: '3:30',
      album: 'Hip-Hop Evolution',
      favorite: false,
    },
  ];

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }
}
