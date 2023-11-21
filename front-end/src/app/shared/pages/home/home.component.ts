import { Component, OnInit } from '@angular/core';
import { Song } from 'src/types/Song';
import { SongService } from '../../services/songs/song.service';
import { UserService } from '../../services/users/user.service';
import Cookies from 'js-cookie';

@Component({
  selector: 'shared-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  musicList: Song[] = [];
  favoriteSongs: Song[] = [];

  constructor(
    private songService: SongService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.userService
      .favoriteSongs(Cookies.get('username') as string)
      .subscribe((songs: any) => {
        this.favoriteSongs = songs;
        console.log('Favorite songs:', this.favoriteSongs);
      });

    this.songService.getSongs().subscribe((songs: any) => {
      this.musicList = songs;
      console.log('All songs:', this.musicList);
    });

    this.musicList = this.musicList.map((song) => ({
      ...song,
      favorite: this.favoriteSongs.some((favSong) => favSong.id === song.id),
    }));
  }

  async toggleHeartColor(song: Song) {
    if (!song.favorite) {
      song.likes!++;
      song.favorite = true;
      await this.userService.addLike(
        song.id,
        Cookies.get('username') as string
      );
      await this.songService.addLike(song.id);
    } else {
      song.likes!--;
      await this.userService.removeLike(
        song.id,
        Cookies.get('username') as string
      );
      await this.songService.removeLike(song.id);
    }
  }
}
