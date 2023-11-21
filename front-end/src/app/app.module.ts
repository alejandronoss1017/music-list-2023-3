import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationComponent } from './shared/pages/authentication/authentication.component';
import { MainComponent } from './shared/pages/main/main.component';
import { SharedModule } from './shared/shared.module';
import { AdminModule } from './admin/admin.module';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
  declarations: [AppComponent, AuthenticationComponent, MainComponent],
  providers: [],
  bootstrap: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    AdminModule,
    HttpClientModule,
  ],
})
export class AppModule {}
