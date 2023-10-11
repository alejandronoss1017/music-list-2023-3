import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './shared/pages/authentication/authentication.component';
import { MainComponent } from './shared/pages/main/main.component';
import { HomeComponent } from './shared/pages/home/home.component';
import { GenresComponent } from './shared/pages/genres/genres.component';

const routes: Routes = [
  {path: 'authentication', component: AuthenticationComponent},
  {path: 'main', component: MainComponent,
    children:[
       {path: '', component: HomeComponent},
       {path: 'genre', component: GenresComponent}
    ]},
  {path: '**', redirectTo: '/authentication', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
