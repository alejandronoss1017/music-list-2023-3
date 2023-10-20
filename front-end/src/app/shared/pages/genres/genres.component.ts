import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'shared-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css']
})
export class GenresComponent {

  genres: string[] = ['rock', 'pop', 'hiphop', 'electronic', 'metal', 'vallenato'];

  constructor(private router: Router) {}

  navigateToGenre(genre: string): void {
    this.router.navigate(['/genre', genre]);
  }
}
