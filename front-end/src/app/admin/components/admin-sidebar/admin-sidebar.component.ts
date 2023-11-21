import { Component } from '@angular/core';
import { AuthService } from '../../../shared/services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css'],
})
export class AdminSidebarComponent {
  constructor(private router: Router, private authService: AuthService) {}

  isCurrentRoute(route: string): boolean {
    return this.router.url === route;
  }

  logout() {
    this.authService.logout();
  }
}
