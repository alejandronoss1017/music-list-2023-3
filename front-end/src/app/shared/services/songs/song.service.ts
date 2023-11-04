import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root',
})
export class SongService {

  private apiUrl = environment.backendUrl + 'song';

  constructor(private http: HttpClient) {}

  getSongs() {
    return this.http.get(`${this.apiUrl}/${'all'}`);
  }

  formatDuration(duration: number): string {
    const minutes = Math.floor(duration / 60);
    const seconds = duration % 60;
    return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
  }
}
