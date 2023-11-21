import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { LoginRequest } from 'src/types/LoginRequest';
import Cookies from 'js-cookie';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css'],
})
export class AuthenticationComponent implements OnInit {
  // Define the form group
  authForm: FormGroup;

  ngOnInit(): void {}

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.authForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  async onSubmit() {
    await this.authService.login(this.authForm.value as LoginRequest);

    if (Cookies.get('role') == 'Admin' || Cookies.get('role') == 'User') {
      await this.authService.verifyRole(Cookies.get('role') as string);

      switch (Cookies.get('role')) {
        case 'Admin':
          this.router.navigate(['/admin']);
          break;
        case 'User':
          this.router.navigate(['/main']);
          break;
        default:
          console.log('You are not logged in');
      }
    }
    console.log('You are not logged in');
  }
}
