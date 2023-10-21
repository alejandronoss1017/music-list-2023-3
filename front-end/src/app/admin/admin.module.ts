import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMainPageComponent } from './pages/admin-main-page/admin-main-page.component';
import { AdminGenreComponent } from './pages/admin-genre/admin-genre.component';
import { AdminSongComponent } from './pages/admin-song/admin-song.component';
import { AdminSidebarComponent } from './components/admin-sidebar/admin-sidebar.component';
import { SharedModule } from "../shared/shared.module";
import { RouterModule } from '@angular/router';
import { GenreCComponent } from './pages/genre-c/genre-c.component';
import { GenreDComponent } from './pages/genre-d/genre-d.component';
import { GenreRComponent } from './pages/genre-r/genre-r.component';
import { GenreUComponent } from './pages/genre-u/genre-u.component';
import { SongCComponent } from './pages/song-c/song-c.component';
import { SongUComponent } from './pages/song-u/song-u.component';
import { SongRComponent } from './pages/song-r/song-r.component';
import { SongDComponent } from './pages/song-d/song-d.component';
import { FormsModule } from '@angular/forms'; // Import FormsModule


@NgModule({
    declarations: [
        AdminMainPageComponent,
        AdminGenreComponent,
        AdminSongComponent,
        AdminSidebarComponent,
        GenreCComponent,
        GenreDComponent,
        GenreRComponent,
        GenreUComponent,
        SongCComponent,
        SongUComponent,
        SongRComponent,
        SongDComponent,
    ],
    imports: [
        CommonModule,
        SharedModule,
        RouterModule,
        FormsModule
    ],
    exports: [
        AdminSidebarComponent
    ]
})
export class AdminModule { }
