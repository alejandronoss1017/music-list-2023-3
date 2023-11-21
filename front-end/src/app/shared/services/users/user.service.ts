import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { Song } from 'src/types/Song';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = environment.backendUrl + 'songLike';

  constructor(private http: HttpClient) {}

  async addLike(songId: number, username: string) {
    try {
      return await this.http
        .post(`${this.apiUrl}/add`, {
          songId: songId,
          username: username,
        })
        .toPromise();
    } catch (error) {
      console.log(error);
      return error;
    }
  }

  async removeLike(songId: number, username: string) {
    try {
      console.log('Delete: ', songId, username);
      return await this.http
        .delete(`${this.apiUrl}/delete/${songId}/${username}`)
        .toPromise();
    } catch (error) {
      console.log(error);
      return error;
    }
  }

  favoriteSongs(username: string): Observable<Song[]> {
    return this.http.get<Song[]>(`${this.apiUrl}/get/${username}`);
  }

  registerUser(user: any) {
    return this.http.post(`${this.apiUrl}/add`, user);
  }
}
