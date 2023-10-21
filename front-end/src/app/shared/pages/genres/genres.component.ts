import { Component, OnInit } from '@angular/core';
import { Genre } from 'src/types/Genre';
import { GenreService } from '../../services/genres/genre.service';

@Component({
  selector: 'shared-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css'],
})
export class GenresComponent implements OnInit {

  genres: Genre[] = [];

  constructor(private genreService: GenreService) {}

  ngOnInit(): void {
    this.genreService.getGenres().subscribe((genres: any) => {
      console.log(genres);
      this.genres = genres;
    });
  }


  navigateToGenre(genre: string) {
    console.log(genre);
  }
}
