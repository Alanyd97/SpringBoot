import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product/product-service.service';
import { Product } from 'src/app/models/cart/product/product/product.module';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public products : Product[];
  constructor(private _product:ProductService) { 
  }

  ngOnInit(): void {
    this._product.getProducts()
      .subscribe(data => this.products = data
    );
  }

  setQantityPlus(product:Product){
    if(!product.quantity){
      product.quantity = 0;
    }
    product.quantity++;
    console.log(product.quantity);
  }

  
  setQantityLess(product:Product){
    if(!product.quantity){
      product.quantity = 0;
    }
    if(product.quantity-1 > 0){
      product.quantity--;
    }
    console.log(product.quantity);
  }

  addToCart(){
    
  }

}
