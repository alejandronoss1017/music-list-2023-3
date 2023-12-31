import { AuthService } from './../../services/auth/auth.service';
import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'shared-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent {
  constructor(private router: Router, private authService: AuthService) {}

  isCurrentRoute(route: string): boolean {
    return this.router.url === route;
  }

  logout() {
    this.authService.logout();
  }
}
