import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenreService } from '../../services/genres/genre.service';
import { Location } from '@angular/common';
import { Genre } from 'src/types/Genre';
@Component({
  selector: 'app-admin-create-genre',
  templateUrl: './admin-create-genre.component.html',
  styleUrls: ['./admin-create-genre.component.css'],
})
export class AdminCreateGenreComponent {
  // Define the form group
  genreForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private genre: GenreService,
    private location: Location,
    private genreService: GenreService
  ) {
    // Create the form
    this.genreForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
    });
  }

  onSubmit() {
    // Check if the form is valid
    if (!this.genreForm.valid) {
      window.alert('Invalid form');
      return;
    }

    this.genreService.createGenre(this.genreForm.value as Genre);

    this.location.back();
  }
}
