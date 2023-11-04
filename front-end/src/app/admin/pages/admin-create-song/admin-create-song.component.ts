import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SongService } from '../../services/songs/song.service';
import { Song } from 'src/types/Song';
import { Location } from '@angular/common';
import { Genre } from 'src/types/Genre';
import { GenreService as GenreServicePublic } from 'src/app/shared/services/genres/genre.service';

@Component({
  selector: 'app-admin-create-song',
  templateUrl: './admin-create-song.component.html',
  styleUrls: ['./admin-create-song.component.css'],
})
export class AdminCreateSongComponent implements OnInit {
  // Define the form group
  songForm: FormGroup;

  genres: Genre[] = [];

  ngOnInit(): void {
    this.genreServicePublic.getGenres().subscribe((genres) => {
      this.genres = genres as Genre[];
    });
  }

  // Inject the FormBuilder
  constructor(
    private fb: FormBuilder,
    private songService: SongService,
    private location: Location,
    private genreServicePublic: GenreServicePublic
  ) {
    // Create the form
    this.songForm = this.fb.group({
      name: ['', Validators.required],
      artist: ['', Validators.required],
      album: ['', Validators.required],
      duration: ['', Validators.required],
      releaseDate: ['', Validators.required],
      genreId: ['', Validators.required],
    });
  }

  onSubmit() {
    // Check if the form is valid
    if (!this.songForm.valid) {
      window.alert('Invalid form');
      return;
    }

    console.log(this.songForm.value);
    this.songService.createSong(this.songForm.value as Song);

    this.location.back();
  }
}
