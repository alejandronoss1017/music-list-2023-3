import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-genre-page',
  templateUrl: './genre-page.component.html',
  styleUrls: ['./genre-page.component.css']
})
export class GenrePageComponent implements OnInit {
  musicList: any[] = [];
  genre: string = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.genre = params['genre'];
      this.loadMusicList(); // Load music list based on the genre
    });
  }

  loadMusicList() {
    // You can load the music list based on the genre using an HTTP request or manually.
    // For demonstration purposes, I'll provide an example of manually setting the music list.
    if (this.genre === 'rock') {
      this.musicList = [
        { title: 'Song Title 1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
        // Add more rock songs here
      ];
    } else if (this.genre === 'pop') {
      this.musicList = [
        { title: 'Song Title 1', artist: 'Artist Name 1', duration: '4:20', album: 'Album Name 1' },
        // Add more pop songs here
      ];
    }
  }

  favoriteStates: boolean[] = new Array(this.musicList.length).fill(false);
  toggleHeartColor(index: number) {
    this.favoriteStates[index] = !this.favoriteStates[index];
  }
}
