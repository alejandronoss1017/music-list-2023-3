import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class GenreService {
  private apiUrl = 'http://localhost:8080/genre';

  constructor(private http: HttpClient) {}

  getGenres() {
    return this.http.get(`${this.apiUrl}/${'all'}`);
  }
}
