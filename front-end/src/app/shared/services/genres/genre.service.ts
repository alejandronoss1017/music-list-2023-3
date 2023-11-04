import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root',
})
export class GenreService {
  private apiUrl = environment.backendUrl + 'genre';

  constructor(private http: HttpClient) {}

  getGenres() {
    return this.http.get(`${this.apiUrl}/${'all'}`);
  }

  getGenreIdByName(name: string) {
    return this.http.get(`${this.apiUrl}/name/${name}`);
  }
}
