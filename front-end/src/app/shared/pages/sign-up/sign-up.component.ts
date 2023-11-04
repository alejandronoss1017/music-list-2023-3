import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
})
export class SignUpComponent implements OnInit {
  // Define the form group
  registerForm: FormGroup;


  // TODO: Inject the users service
  // Inject the FormBuilder
  constructor(private fb: FormBuilder, private router: Router) {
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

  onSubmit() {
    // TODO: Call the users service to create a user

    // Change page to home
    this.router.navigate(['/main']);
  }
}
