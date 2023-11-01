import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMainPageComponent } from './pages/admin-main-page/admin-main-page.component';
import { AdminGenreComponent } from './pages/admin-genre/admin-genre.component';
import { AdminSongComponent } from './pages/admin-song/admin-song.component';
import { AdminSidebarComponent } from './components/admin-sidebar/admin-sidebar.component';
import { SharedModule } from '../shared/shared.module';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminUpdateSongComponent } from './pages/admin-update-song/admin-update-song.component';
import { AdminUpdateGenreComponent } from './pages/admin-update-genre/admin-update-genre.component';
import { AdminCreateGenreComponent } from './pages/admin-create-genre/admin-create-genre.component';
import { AdminCreateSongComponent } from './pages/admin-create-song/admin-create-song.component';

@NgModule({
  declarations: [
    AdminMainPageComponent,
    AdminGenreComponent,
    AdminSongComponent,
    AdminSidebarComponent,
    AdminUpdateSongComponent,
    AdminUpdateGenreComponent,
    AdminCreateGenreComponent,
    AdminCreateSongComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class AdminModule {}
