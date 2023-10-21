import { Component } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  musicList = [
  { name: 'Cancion1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
  { name: 'Song name 1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
  { name: 'Song name 2', artist: 'Artist Name 2', duration: '3:45', album: 'Album Name 2' },
  { name: 'Another Song', artist: 'Another Artist', duration: '3:15', album: 'Another Album' },
  { name: 'Hit Song', artist: 'Famous Artist', duration: '2:50', album: 'Greatest Hits' },
  { name: 'Cool Tune', artist: 'Cool Artist', duration: '3:10', album: 'Cool Album' },
  { name: 'Jazz Groove', artist: 'Jazz Ensemble', duration: '5:30', album: 'Smooth Jazz' },
  { name: 'Rock Anthem', artist: 'Rock Band', duration: '4:15', album: 'Rock Classics' },
  { name: 'Dance Beat', artist: 'DJ Mixmaster', duration: '4:00', album: 'Club Hits' },
  { name: 'Country Ballad', artist: 'Country Singer', duration: '3:55', album: 'Country Stories' },
  { name: 'Rap Rhymes', artist: 'Rapper MC', duration: '3:30', album: 'Hip-Hop Evolution' },
  ];

filteredMusicList: Array<{ name: string; artist: string; duration: string; album: string }> = [];

  searchSong(term: string): void {
    console.log('Searching for songs with term:', term);
    this.filteredMusicList = this.musicList.filter((musicItem) =>
      musicItem.name.toLowerCase().includes(term.toLowerCase())
    );
  }

  favoriteStates: boolean[] = new Array(this.musicList.length).fill(false);

  toggleHeartColor(index: number) {
    this.favoriteStates[index] = !this.favoriteStates[index];
  }
}
