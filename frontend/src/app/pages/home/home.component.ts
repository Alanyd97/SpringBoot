import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product/product-service.service';

import {Router} from "@angular/router"
import { User } from 'src/app/models/cart/user/user.module';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public products = [];
  private user: User;

  constructor(private _product: ProductService, private router: Router) {
    this.user = JSON.parse(localStorage.getItem('usuario'));
    if(this.user == null){
      console.log("entre pero me fui");
      this.router.navigate(["/login"]);
      
    }

  }

  ngOnInit(): void {
    this._product.getProducts()
      .subscribe(data => this.products =  data);
  }

  try(){
    console.log(this.products);
    
  }
}
