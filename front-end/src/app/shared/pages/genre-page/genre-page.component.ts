import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from 'src/types/Song';
import { SongService } from '../../services/songs/song.service';
import { GenreService } from '../../services/genres/genre.service';

@Component({
  selector: 'app-genre-page',
  templateUrl: './genre-page.component.html',
  styleUrls: ['./genre-page.component.css']
})
export class GenrePageComponent implements OnInit {
  musicList: Song[] = [];
  genre: string = '';
  genreId: number = 0;

  constructor(private route: ActivatedRoute, 
    private songService: SongService, 
    private genreService: GenreService) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
    this.genre = params['genre'].toUpperCase();
    // Fetch the genre ID using the GenreService
    this.genreService.getGenreIdByName(this.genre).subscribe((response: any) => {
        this.genreId = response.id;
        console.log(this.genreId);
        this.loadMusicList(); // Load music list based on the genre
    });
    });
  }

  toggleHeartColor(song: Song) {
    song.favorite = !song.favorite;
  }

  loadMusicList() {
    // `getSongsByGenreId` method to fetch songs by genre ID.
    this.songService.getSongsByGenreId(this.genreId).subscribe((songs: any) => {
      this.musicList = songs;
    });
  }

}
