import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  user = {} as User
  wrongLogin = false

  constructor(private userService: UsersService,
              private router: Router) { }

  ngOnInit(): void {
  }

  submit(form: NgForm) {
    if(form.invalid){
      return;
    }

    //encrypt password
    this.user.password = btoa(this.user.password)
    this.userService.login(this.user)
      .subscribe(value => {
        if(value){
          this.router.navigate(['/']);
        } else {
          this.wrongLogin = true
          setInterval(() => {
            this.wrongLogin = false;
          }, 2000)
        }
      },
      error => {
        this.wrongLogin = true
        setInterval(() => {
          this.wrongLogin = false;
        }, 2000)
      })
  }

}
