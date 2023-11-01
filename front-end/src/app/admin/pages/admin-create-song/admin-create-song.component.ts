import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SongService } from '../../services/songs/song.service';
import { Song } from 'src/types/Song';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-create-song',
  templateUrl: './admin-create-song.component.html',
  styleUrls: ['./admin-create-song.component.css'],
})
export class AdminCreateSongComponent {
  // Define the form group
  songForm: FormGroup;

  // Inject the FormBuilder
  constructor(
    private fb: FormBuilder,
    private songService: SongService,
    private location: Location
  ) {
    // Create the form
    this.songForm = this.fb.group({
      name: ['', Validators.required],
      artist: ['', Validators.required],
      album: ['', Validators.required],
      duration: ['', Validators.required],
      releaseDate: ['', Validators.required],
    });
  }

  onSubmit() {
    // Check if the form is valid
    if (!this.songForm.valid) {
      window.alert('Invalid form');
      return;
    }

    this.songService.createSong(this.songForm.value as Song);

    this.location.back();
  }
}
