import { RegisterRequest } from './../../../../types/RegisterRequest';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { LoginRequest } from 'src/types/LoginRequest';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = environment.authApiUrl;

  constructor(private http: HttpClient) {}

  login(loginRequest: LoginRequest) {
    console.log(loginRequest);
    return this.http.post(`${this.apiUrl}` + 'login', loginRequest).subscribe();
  }

  logout() {
    //TODO: Implement logout
  }

  isLoggedIn() {
    //TODO: Implement isLoggedIn
  }

  register(registerRequest: RegisterRequest) {
    console.log(registerRequest);

    return this.http
      .post(`${this.apiUrl}` + 'register', registerRequest)
      .subscribe();
  }
}
