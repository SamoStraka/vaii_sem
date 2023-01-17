import { Component } from '@angular/core';
import {Observable} from "rxjs";
import {User} from "./user";
import {UsersService} from "./users.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  user$: Observable<User | undefined>;
  constructor(private userService: UsersService) {
    this.user$ = userService.onUserChange()
  }

}
