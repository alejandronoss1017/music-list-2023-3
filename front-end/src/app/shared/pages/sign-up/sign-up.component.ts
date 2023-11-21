import { AuthService } from './../../services/auth/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterRequest } from 'src/types/RegisterRequest';
import { UserService } from '../../services/users/user.service';
import Cookies from 'js-cookie';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
})
export class SignUpComponent implements OnInit {
  // Define the form group
  registerForm: FormGroup;

  // Inject the FormBuilder
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService,
    private userService: UserService
  ) {
    // Create the form
    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    // TODO: Implement users service to create a user
  }

  async onSubmit() {
    
    const response = await this.authService.register(this.registerForm.value as RegisterRequest);
    console.log("Form: " + this.registerForm.value);
    
    // Crear el usuario en la base de datos del backend musiclist
    this.userService.registerUser(this.registerForm.value);

    if (response) {
      const loginRequest = {
        username: this.registerForm.value.username,
        password: this.registerForm.value.password,
      };

      await this.authService.login(loginRequest);

      Cookies.set('username', this.registerForm.value.username);

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
}
