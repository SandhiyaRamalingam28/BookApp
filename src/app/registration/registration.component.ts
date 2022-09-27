import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Users } from '../users';
import { RegistrationService } from '../registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  users = new Users();
  msg='';

  constructor(private _service : RegistrationService,private _router : Router) { }

  ngOnInit(){
  }
  registerUsers(){
    this._service.registerUsersFromRemote(this.users).subscribe(
      data =>{
        console.log("Registration Completed");
        //this.msg="Registratiom successful";
        this._router.navigate(['/login']);
        
      },
      error =>{
        console.log("exception occured");
        this.msg="EmailId already exists"; 
      }
    )
  }
  existingUser(){
    console.log("jdc")
    this._router.navigate(['/login']);
  }


}
