import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonComponent } from './shared/components/button/button.component';
import { AuthenticationComponent } from './shared/pages/authentication/authentication.component';
import { MainComponent } from './shared/pages/main/main.component';

@NgModule({
  declarations: [
    AppComponent,
    ButtonComponent,
    AuthenticationComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
