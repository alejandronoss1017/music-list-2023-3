import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './pages/home/home.component';
import { GenresComponent } from './pages/genres/genres.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LikedsongsComponent } from './pages/likedsongs/likedsongs.component';



@NgModule({
  declarations: [
    HomeComponent,
    GenresComponent,
    SidebarComponent,
    NavbarComponent,
    LikedsongsComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    HomeComponent,
    SidebarComponent,
    NavbarComponent
  ]
})
export class SharedModule { }
