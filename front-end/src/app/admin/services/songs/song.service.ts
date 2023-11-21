import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { Song } from 'src/types/Song';

@Injectable({
  providedIn: 'root',
})
export class SongService {
  private apiUrl = environment.backendUrl + 'song';

  constructor(private http: HttpClient) {}

  formatDuration(duration: string): number {
    const durationParts = duration.split(':');

    const minutes = parseInt(durationParts[0], 10);
    const seconds = parseInt(durationParts[1], 10);

    return minutes * 60 + seconds;
  }

  getSongById(id: string) {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  createSong(song: Song): boolean {
    try {
      if (typeof song.duration === 'string') {
        song.duration = this.formatDuration(song.duration as string);
      }

      this.http.post(`${this.apiUrl}/${'add'}`, song).subscribe();
      return true;
    } catch (error) {
      console.log(error);
    }
    return false;
  }

  updateSong(id: number, song: Song) {
    return this.http.put(`${this.apiUrl}/update/${id}`, song);
  }

  deleteSong(id: number) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}
