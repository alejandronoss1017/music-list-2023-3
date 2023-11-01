import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SongService } from '../../services/songs/song.service';
import { Song } from 'src/types/Song';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-update-song',
  templateUrl: './admin-update-song.component.html',
  styleUrls: ['./admin-update-song.component.css'],
})
export class AdminUpdateSongComponent implements OnInit {
  songForm: FormGroup;

  id: string | null = '';

  song: Song = {} as Song;

  // Inject the FormBuilder
  constructor(
    private fb: FormBuilder,
    private songService: SongService,
    private route: ActivatedRoute,
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

    //Get the id from the route
    this.route.paramMap.subscribe((params) => {
      this.id = params.get('id');
    });

    // Get the song from the state
    this.song = history.state.song;
  }
  ngOnInit(): void {
    this.songForm.patchValue(this.song);
  }

  onSubmit() {
    // Check if the form is valid
    if (!this.songForm.valid) {
      window.alert('Invalid form');
      return;
    }

    this.songService
      .updateSong(parseInt(this.id!), this.songForm.value as Song)
      .subscribe();

    this.location.back();
  }
}
