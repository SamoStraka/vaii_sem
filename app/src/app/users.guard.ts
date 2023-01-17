import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {User} from "./user";
import {UsersService} from "./users.service";

@Injectable({
  providedIn: 'root'
})
export class UsersGuard implements CanActivate {

  private user: User | undefined;

  constructor(private userService: UsersService, private router: Router) {
    userService.onUserChange()
      .subscribe(value => {
        this.user = value;
      })
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    return this.user ? true : this.router.parseUrl('/login');
  }

}
