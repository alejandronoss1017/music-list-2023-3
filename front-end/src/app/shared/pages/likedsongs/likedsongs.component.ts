import { Component } from '@angular/core';
import { Song } from 'src/types/Song';

@Component({
  selector: 'app-likedsongs',
  templateUrl: './likedsongs.component.html',
  styleUrls: ['./likedsongs.component.css'],
})
export class LikedsongsComponent {
  musicList: Song[] = [
    {
      title: 'Cancion1',
      artist: 'Artist Name 1',
      duration: '4:20',
      album: 'Album Name 1',
      favorite: true,
    },
    {
      title: 'Song Title 1',
      artist: 'Artist Name 1',
      duration: '4:20',
      album: 'Album Name 1',
      favorite: true,
    },
    {
      title: 'Song Title 2',
      artist: 'Artist Name 2',
      duration: '3:45',
      album: 'Album Name 2',
      favorite: true,
    },
    {
      title: 'Another Song',
      artist: 'Another Artist',
      duration: '3:15',
      album: 'Another Album',
      favorite: true,
    },
    {
      title: 'Hit Song',
      artist: 'Famous Artist',
      duration: '2:50',
      album: 'Greatest Hits',
      favorite: true,
    },
    {
      title: 'Cool Tune',
      artist: 'Cool Artist',
      duration: '3:10',
      album: 'Cool Album',
      favorite: true,
    },
    {
      title: 'Jazz Groove',
      artist: 'Jazz Ensemble',
      duration: '5:30',
      album: 'Smooth Jazz',
      favorite: true,
    },
    {
      title: 'Rock Anthem',
      artist: 'Rock Band',
      duration: '4:15',
      album: 'Rock Classics',
      favorite: true,
    },
    {
      title: 'Dance Beat',
      artist: 'DJ Mixmaster',
      duration: '4:00',
      album: 'Club Hits',
      favorite: true,
    },
    {
      title: 'Country Ballad',
      artist: 'Country Singer',
      duration: '3:55',
      album: 'Country Stories',
      favorite: true,
    },
    {
      title: 'Rap Rhymes',
      artist: 'Rapper MC',
      duration: '3:30',
      album: 'Hip-Hop Evolution',
      favorite: true,
    },
  ];

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }
}
