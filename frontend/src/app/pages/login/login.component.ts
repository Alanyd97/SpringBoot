import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/cart/user/user.module';
import { LoginService } from 'src/app/services/login/login.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMessage:string = "";
  private user : User = {
    userName: "",
    password: ""
  }
  constructor(private _login:LoginService, private router: Router) { 
    if(!this._login.isLogged){
      this.router.navigate(["/home"]);
    }
  }

  ngOnInit(): void {

  }

  login(){
    this._login.login(this.user);

    if(this._login.isLogged()){
      this.router.navigate(["/home"]);
    }
    this.errorMessage = "Contraseña y/o nombre de usuario incorrectos";
  }

  setUserName(event){
   this.user.userName = event.target.value;
  }

  setPassword(event){
    this.user.password =  event.target.value
  }

}
