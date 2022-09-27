import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { Users } from '../users';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  users = new Users();
  msg='';

  constructor(private service : RegistrationService , private router: Router) { }

  ngOnInit(){
  }
  homePageFromRemote(){
    this.service.homePageFromRemote(this.users).subscribe(
      data => {
        console.log("response recieved from home")
        this.router.navigate(['/home'])
      },
      error => {
        console.log("Exception occured");
        //this.msg="Error in Home page";
      }
    )
  }
  
}
