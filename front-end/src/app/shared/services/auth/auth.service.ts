import { Router } from '@angular/router';
import { RegisterRequest } from './../../../../types/RegisterRequest';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Cookies from 'js-cookie';
import { environment } from 'src/environment/environment';
import { LoginRequest } from 'src/types/LoginRequest';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = environment.authApiUrl;

  constructor(private http: HttpClient, private router: Router) {}

  async login(loginRequest: LoginRequest) {
    try {
      const response: any = await this.http
        .post(`${this.apiUrl}` + 'login', loginRequest)
        .toPromise();

      if (response && response.token) {
        Cookies.set('token', response.token);
        Cookies.set('role', response.admin ? 'Admin' : 'User');
      } else {
        console.error('Invalid response format from server');
      }
    } catch (error) {
      console.log(error);
    }
  }

  logout() {
    Cookies.remove('token', { path: '/' });
    Cookies.remove('role', { path: '/' });
    Cookies.remove('username', { path: '/' });
    this.router.navigate(['/authentication']);
  }

  isLoggedIn() {
    //TODO: Implement isLoggedIn
  }

  async verifyRole(role: string) {
    try {
      const response: any = await this.http
        .get(`${this.apiUrl}` + `verifyRole${Cookies.get('role')}`, {
          headers: {
            'content-type': 'application/json',
            Authorization: `Bearer ${Cookies.get('token')}`,
          },
        })
        .toPromise();
      return response;
    } catch (error) {
      console.error(`You are not a ${role}`, error);
      return false;
    }
  }

  async register(registerRequest: RegisterRequest) {
    try{
       await this.http
      .post(`${this.apiUrl}` + 'register', registerRequest)
      .toPromise();
      return true;
    }catch(error){
      console.error('Error registering user', error);
      return false;
      }
    }
}
