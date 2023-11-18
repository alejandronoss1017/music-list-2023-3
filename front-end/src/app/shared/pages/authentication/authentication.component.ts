import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { LoginRequest } from 'src/types/LoginRequest';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css'],
})
export class AuthenticationComponent implements OnInit {
  // Define the form group
  authForm: FormGroup;

  ngOnInit(): void {}

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.authForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  onSubmit() {
    this.authService.login(this.authForm.value as LoginRequest);
  }
}
