import { UserService } from './../../services/users/user.service';
import { Component, OnInit } from '@angular/core';
import { Song } from 'src/types/Song';
import { SongService } from '../../services/songs/song.service';
import Cookies from 'js-cookie';

@Component({
  selector: 'app-liked-songs',
  templateUrl: './liked-songs.component.html',
  styleUrls: ['./liked-songs.component.css'],
})
export class LikedSongsComponent implements OnInit {
  favoriteSongs: Song[] = [];

  constructor(
    private songService: SongService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.userService.favoriteSongs(Cookies.get('username') as string).subscribe((songs) => {
      console.log(songs);
      this.favoriteSongs = songs;
    });
  }

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }
}
