import { Component } from '@angular/core';

@Component({
  selector: 'app-genre-c',
  templateUrl: './genre-c.component.html',
  styleUrls: ['./genre-c.component.css']
})
export class GenreCComponent {
  numSongs: number = 0; // Initialize numSongs with 0

  // Define properties and methods used in the template
  onSubmit() {
    // Implement your form submission logic here
    console.log('Form submitted');
  }

  getDynamicInputs() {
    // Return an array of numbers based on numSongs
    return Array.from({ length: this.numSongs }, (_, i) => i + 1);
  }
}
