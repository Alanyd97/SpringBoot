import { Injectable } from '@angular/core';
import { User } from 'src/app/models/cart/user/user.module';
import {Router} from "@angular/router"

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private user:User;
  constructor( private router: Router) { }

  isLogged(){
    this.user = JSON.parse(localStorage.getItem('user'));
    if(this.user == null){
      this.router.navigate(["/login"]);
      return false;
    }
    return true;
  }
}
