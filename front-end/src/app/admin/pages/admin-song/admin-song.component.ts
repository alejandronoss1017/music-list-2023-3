import { Component, OnInit } from '@angular/core';
import { SongService as SongServicePublic } from 'src/app/shared/services/songs/song.service';
import { SongService as SongServicePrivate } from '../../services/songs/song.service';
import { Song } from 'src/types/Song';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-song',
  templateUrl: './admin-song.component.html',
  styleUrls: ['./admin-song.component.css'],
})
export class AdminSongComponent implements OnInit {
  songs: Song[] = [];

  constructor(
    private songServicePublic: SongServicePublic,
    private songServicePrivate: SongServicePrivate,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.songServicePublic.getSongs().subscribe((songs) => {
      this.songs = songs as Song[];
    });
  }

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }

  deleteSong(song: Song) {
    this.songs = this.songs.filter((s) => s.id !== song.id);
    this.songServicePrivate.deleteSong(song.id!).subscribe();
  }

  goToUpdateSong(song: Song) {
    this.router.navigate([`admin/update/${song.id}`], { state: { song } });
  }
}
