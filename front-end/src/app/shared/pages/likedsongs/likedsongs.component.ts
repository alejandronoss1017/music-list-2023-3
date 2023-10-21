import { Component, OnInit } from '@angular/core';
import { Song } from 'src/types/Song';
import { SongService } from '../../services/songs/song.service';

@Component({
  selector: 'app-likedsongs',
  templateUrl: './likedsongs.component.html',
  styleUrls: ['./likedsongs.component.css'],
})
export class LikedsongsComponent implements OnInit {
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
