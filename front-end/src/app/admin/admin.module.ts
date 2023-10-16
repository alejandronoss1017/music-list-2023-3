import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminMainPageComponent } from './pages/admin-main-page/admin-main-page.component';
import { AdminGenreComponent } from './pages/admin-genre/admin-genre.component';
import { AdminSongComponent } from './pages/admin-song/admin-song.component';
import { AdminSidebarComponent } from './components/admin-sidebar/admin-sidebar.component';
import { SharedModule } from "../shared/shared.module";
import { RouterModule } from '@angular/router';


@NgModule({
    declarations: [
        AdminMainPageComponent,
        AdminGenreComponent,
        AdminSongComponent,
        AdminSidebarComponent,
    ],
    imports: [
        CommonModule,
        SharedModule,
        RouterModule
    ]
})
export class AdminModule { }
