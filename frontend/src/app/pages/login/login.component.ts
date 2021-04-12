import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/cart/user/user.module';
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private user:User = 
  {
    userName: "admin",
    password:"admin"
  };

  errorMessage:string = "";
  private password: string;
  private userName: string;
  constructor(private router: Router) { 
    //localStorage.setItem("user", JSON.stringify(this.user));
  }

  ngOnInit(): void {
    this.password = "";
    this.userName = "";
  }
  login(){
    console.log(this.password===this.user.password +"   "+this.userName +"");
    
    if(this.user.userName !== this.userName && this.user.password !== this.password){
      this.errorMessage = "Contraseña y/o nombre de usuario incorrectos";
      this.router.navigate(["/login"]);
    }
    localStorage.setItem("user", JSON.stringify(this.user));
    this.router.navigate(["/home"]);

  }
  setUserName(event){
    console.log( event.target.value);
    
   this.userName = event.target.value;
    
  }

  setPassword(event){
    console.log( event.target.value);
    this.password =  event.target.value
  }

}
