import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './pages/home/home.component';
import { GenresComponent } from './pages/genres/genres.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import { LikedSongsComponent } from './pages/liked-songs/liked-songs.component';
import { SearchComponent } from './pages/search/search.component';
import { SearchBoxComponent } from './components/search-box/search-box.component';
import { ButtonComponent } from './components/button/button.component';
import { GenrePageComponent } from './pages/genre-page/genre-page.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { BannerComponent } from './components/banner/banner.component';
import { FormatDurationPipe } from './pipes/format-duration.pipe';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomeComponent,
    GenresComponent,
    SidebarComponent,
    LikedSongsComponent,
    SearchComponent,
    SearchBoxComponent,
    ButtonComponent,
    GenrePageComponent,
    SignUpComponent,
    BannerComponent,
    FormatDurationPipe,
  ],
  imports: [CommonModule, RouterModule, FormsModule, ReactiveFormsModule],
  exports: [
    HomeComponent,
    SidebarComponent,
    SearchBoxComponent,
    ButtonComponent,
    BannerComponent,
    FormatDurationPipe,
  ],
})
export class SharedModule {}
