import { Component, OnInit } from '@angular/core';
import { Song } from 'src/types/Song';
import { SongService } from '../../services/songs/song.service';

@Component({
  selector: 'shared-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  musicList: Song[] = [];

  constructor(private songService: SongService) {}

  ngOnInit(): void {
    this.songService.getSongs().subscribe((songs: any) => {
      console.log(songs);
      this.musicList = songs;
    });
  }

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }
}
