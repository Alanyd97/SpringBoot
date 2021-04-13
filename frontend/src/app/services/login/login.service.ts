import { Injectable } from '@angular/core';
import { User } from 'src/app/models/cart/user/user.module';
import {Router} from "@angular/router"

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private user:User = {
    userName: "admin",
    password: "admin"
  }
  constructor( private router: Router) { }

  isLogged(){
    let user = JSON.parse(localStorage.getItem('user'));
    if(user == null){
      return false;
    }
    return true;
  }

  login(usr:User){
    if(this.user.userName == usr.userName && this.user.password == usr.password){
      localStorage.setItem("user", JSON.stringify(this.user));
    }
  }
}
