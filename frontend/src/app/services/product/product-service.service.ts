import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient} from '@angular/common/http'
import { Product } from 'src/app/models/cart/product/product/product.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  localHost: string = environment.localHost;
  products:string = "products";
  constructor(protected http: HttpClient) { }

  getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(this.localHost+this.products)
  }
}
