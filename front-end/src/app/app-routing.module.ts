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
import { GenreCComponent } from './admin/pages/genre-c/genre-c.component';
import { GenreRComponent } from './admin/pages/genre-r/genre-r.component';
import { GenreUComponent } from './admin/pages/genre-u/genre-u.component';
import { SongCComponent } from './admin/pages/song-c/song-c.component';
import { SongRComponent } from './admin/pages/song-r/song-r.component';
import { SongUComponent } from './admin/pages/song-u/song-u.component';
import { SongDComponent } from './admin/pages/song-d/song-d.component';
import { GenreDComponent } from './admin/pages/genre-d/genre-d.component';

const routes: Routes = [
  {path: 'authentication', component: AuthenticationComponent},
  {path: 'signup', component: SignUpComponent},
  {path: 'main', component: MainComponent,
    children:[
        {path: '', component: HomeComponent},
        {path: 'genre', component: GenresComponent,
            children: [
              {path: ':genre', component: GenrePageComponent}
            ]
          },
        {path: 'likedsongs', component: LikedsongsComponent},
        {path: 'search', component: SearchComponent}
    ]},
  {path: 'admin', component: AdminMainPageComponent,
    children:[
      {path: 'crudgenres', component: AdminGenreComponent,
        children: 
          [
            {path: '', component: GenreCComponent},
            {path: 'create', component: GenreCComponent},
            {path: 'read', component: GenreRComponent},
            {path: 'update', component: GenreUComponent},
            {path: 'delete', component: GenreDComponent},
          ]
      },
      {path: 'crudsongs', component: AdminSongComponent,
        children: 
          [
            {path: '', component: SongCComponent},
            {path: 'create', component: SongCComponent},
            {path: 'read', component: SongRComponent},
            {path: 'update', component: SongUComponent},
            {path: 'delete', component: SongDComponent},
          ]          
        }
      ]
  },
  {path: '**', redirectTo: '/authentication', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
