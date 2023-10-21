import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'shared-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css'],
})
export class GenresComponent {
  genres: string[] = [
    'rock',
    'pop',
    'hiphop',
    'electronic',
    'metal',
    'vallenato',
    'reggaeton',
    'trap',
    'salsa',
    'ranchera',
    'cumbia',
    'merengue',
    'bachata',
    'balada',
    'bolero',
    'tango',
    'jazz',
    'blues',
    'soul',
    'funk',
    'country',
    'reggae',
    'ska',
    'punk',
    'indie',
    'alternativo',
    'clásica',
  ];

  constructor(private router: Router) {}

  navigateToGenre(genreOMG: string): void {
    this.router.navigate(['/genre', genreOMG]);
  }
}
