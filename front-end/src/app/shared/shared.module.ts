import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './pages/home/home.component';
import { GenresComponent } from './pages/genres/genres.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LikedsongsComponent } from './pages/likedsongs/likedsongs.component';
import { SearchComponent } from './pages/search/search.component';
import { SearchBoxComponent } from './components/search-box/search-box.component';
import { ButtonComponent } from './components/button/button.component';
import { GenrePageComponent } from './pages/genre-page/genre-page.component';



@NgModule({
  declarations: [
    HomeComponent,
    GenresComponent,
    SidebarComponent,
    NavbarComponent,
    LikedsongsComponent,
    SearchComponent,
    SearchBoxComponent,
    ButtonComponent,
    GenrePageComponent,
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    HomeComponent,
    SidebarComponent,
    NavbarComponent,
    SearchBoxComponent,
    ButtonComponent
  ]
})
export class SharedModule { }
