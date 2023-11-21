import { environment } from 'src/environment/environment';

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Genre } from 'src/types/Genre';

@Injectable({
  providedIn: 'root',
})
export class GenreService {
  private apiUrl = environment.backendUrl + 'genre';

  constructor(private http: HttpClient) {}

  getGenreById(id: string) {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  createGenre(genre: Genre): boolean {
    try {
      this.http.post(`${this.apiUrl}/${'add'}`, genre).subscribe();
      return true;
    } catch (error) {
      console.log(error);
    }
    return false;
  }

  updateGenre(id: number, genre: Genre) {
    return this.http.put(`${this.apiUrl}/update/${id}`, genre);
  }

  deleteGenre(id: number) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
