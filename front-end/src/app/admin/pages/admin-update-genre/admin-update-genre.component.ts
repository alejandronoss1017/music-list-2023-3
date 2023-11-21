import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GenreService } from '../../services/genres/genre.service';
import { ActivatedRoute } from '@angular/router';
import { Genre } from 'src/types/Genre';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-update-genre',
  templateUrl: './admin-update-genre.component.html',
  styleUrls: ['./admin-update-genre.component.css'],
})
export class AdminUpdateGenreComponent {
  id: string | null = '';
  genre: Genre = {} as Genre;
  genreForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private location: Location,
    private genreService: GenreService,
    private route: ActivatedRoute
  ) {
    // Create the form
    this.genreForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
    });

    //Get the id from the route
    this.route.paramMap.subscribe((params) => {
      this.id = params.get('id');
      console.log(params);
    });

    // Get the song from the state
    this.genre = history.state.genre;
  }

  ngOnInit(): void {
    this.genreForm.patchValue(this.genre);
  }

  onSubmit() {
    // Check if the form is valid
    if (!this.genreForm.valid) {
      window.alert('Invalid form');
      return;
    }

    this.genreService
      .updateGenre(parseInt(this.id!), this.genreForm.value as Genre)
      .subscribe();

    this.location.back();
  }
}
