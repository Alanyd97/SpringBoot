import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product/product-service.service';

import {Router} from "@angular/router"
import { User } from 'src/app/models/cart/user/user.module';
import { LoginService } from 'src/app/services/login/login.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public products = [];
  private user: User;

  constructor(private _product: ProductService, private _login: LoginService,  private router: Router) {
    this._login.isLogged();
   
  }

  ngOnInit(): void {
  }

  try(){
    console.log(this.products);
    
  }
}
