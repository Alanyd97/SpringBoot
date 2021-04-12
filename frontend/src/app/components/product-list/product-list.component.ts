import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product/product-service.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  public products = [];
  constructor(private _product:ProductService) { 

  }

  ngOnInit(): void {
    this._product.getProducts()
      .subscribe(data => this.products =  data);
  }

}
