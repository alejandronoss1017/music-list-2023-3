import { Component } from '@angular/core';
import { Song } from 'src/types/Song';
import { SongService } from '../../services/songs/song.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {

  musicList: Song[] = [];

  constructor(private songService: SongService) {}

  searchSong(term: string): void {
    console.log('Searching for songs with term:', term);
    this.songService.getSongByName(term).subscribe((songs: any) => {
      this.musicList = songs;
    });
  }

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }
}
