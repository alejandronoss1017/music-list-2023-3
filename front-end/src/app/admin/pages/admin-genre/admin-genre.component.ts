import { GenreService } from './../../../shared/services/genres/genre.service';
import { Genre } from 'src/types/Genre';
import { Component, OnInit } from '@angular/core';
import { GenreService as GenreServicePublic } from 'src/app/shared/services/genres/genre.service';
import { GenreService as GenreServicePrivate } from '../../services/genres/genre.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-genre',
  templateUrl: './admin-genre.component.html',
  styleUrls: ['./admin-genre.component.css'],
})
export class AdminGenreComponent implements OnInit {
  genres: Genre[] = [];
  constructor(
    private genreServicePublic: GenreServicePublic,
    private genreServicePrivate: GenreServicePrivate,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.genreServicePublic.getGenres().subscribe((genres) => {
      this.genres = genres as Genre[];
    });
  }

  deleteGenre(genre: Genre) {
    this.genres = this.genres.filter((s) => s.id !== genre.id);
    this.genreServicePrivate.deleteGenre(genre.id!).subscribe();
  }

  goToUpdateGenre(genre: Genre) {
    this.router.navigate([`admin/genres/update/${genre.id}`], {
      state: { genre },
    });
  }
}
