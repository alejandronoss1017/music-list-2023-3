import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './shared/pages/authentication/authentication.component';
import { MainComponent } from './shared/pages/main/main.component';
import { HomeComponent } from './shared/pages/home/home.component';
import { GenresComponent } from './shared/pages/genres/genres.component';
import { LikedsongsComponent } from './shared/pages/likedsongs/likedsongs.component';
import { SearchComponent } from './shared/pages/search/search.component';
import { GenrePageComponent } from './shared/pages/genre-page/genre-page.component';
import { SignUpComponent } from './shared/pages/sign-up/sign-up.component';
import { AdminMainPageComponent } from './admin/pages/admin-main-page/admin-main-page.component';
import { AdminGenreComponent } from './admin/pages/admin-genre/admin-genre.component';
import { AdminSongComponent } from './admin/pages/admin-song/admin-song.component';
import { AdminUpdateSongComponent } from './admin/pages/admin-update-song/admin-update-song.component';
import { AdminCreateSongComponent } from './admin/pages/admin-create-song/admin-create-song.component';
import { AdminUpdateGenreComponent } from './admin/pages/admin-update-genre/admin-update-genre.component';
import { AdminCreateGenreComponent } from './admin/pages/admin-create-genre/admin-create-genre.component';

const routes: Routes = [
  { path: 'authentication', component: AuthenticationComponent },
  { path: 'signup', component: SignUpComponent },
  {
    path: 'main',
    component: MainComponent,
    children: [
      { path: '', component: HomeComponent },
      {
        path: 'genres',
        component: GenresComponent,
        children: [{ path: ':genre', component: GenrePageComponent }],
      },
      { path: 'likedsongs', component: LikedsongsComponent },
      { path: 'search', component: SearchComponent },
    ],
  },
  {
    path: 'admin',
    component: AdminMainPageComponent,
    children: [
      {
        path: '',
        component: AdminSongComponent,
        children: [
          { path: 'update/:id', component: AdminUpdateSongComponent },
          { path: 'create', component: AdminCreateSongComponent },
        ],
      },
      {
        path: 'genres',
        component: AdminGenreComponent,
        children: [
          { path: 'update/:id', component: AdminUpdateGenreComponent },
          { path: 'create', component: AdminCreateGenreComponent },
        ],
      },
    ],
  },
  { path: '**', redirectTo: '/authentication', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
