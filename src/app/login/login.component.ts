import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { data } from 'autoprefixer';
import { RegistrationService } from '../registration.service';
import { Users } from '../users';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  users = new Users();
  msg='';
  constructor(private _service : RegistrationService, private _router: Router) {}

  ngOnInit() {
  }

  loginUsers(){
    localStorage.clear;
    this._service.loginUsersFromRemote(this.users).subscribe(
      data => {
        console.log("response recieved")
        this.users=data;
        localStorage.setItem("userId", JSON.stringify(this.users.id));
        this._router.navigate(['/home'])

      },
      error => {
        console.log("exception occured");
        this.msg="Bad credentials, Please enter valid EmailId and Password";
    }
    )
  }
  gotoregistration(){
    this._router.navigate(['/registration'])
  }

}
function loginUsers() {
  throw new Error('Function not implemented.');
}

