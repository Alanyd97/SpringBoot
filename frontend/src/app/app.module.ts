import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { CartComponent } from './components/cart/cart.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './pages/login/login.component';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { ProductListComponent } from './components/product-list/product-list.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CartComponent,
    LoginComponent,
    NavbarComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
