import { Component, OnInit } from '@angular/core';
import {ContactsService} from "../contacts.service";
import {Author} from "../author";
import {Contact} from "../contact";
import {Router} from "@angular/router";
import {UsersService} from "../users.service";
import {User} from "../user";
import {Observable} from "rxjs";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {

  name : string = ''
  email : string = ''
  subject : string = ''
  message: string = ''
  user$: Observable<User | undefined>


  constructor(
    private readonly contactService: ContactsService,
    private router: Router,
    private readonly userService: UsersService
  ) {
    this.user$ = userService.onUserChange()
  }

  logout() {
    this.userService.logout()
  }

  submit(form: any) {
    if (form.invalid) {
      return
    }
    let newId: number = 0
    this.contactService.getAll()
      .subscribe(value => {
        value.forEach(val => {
          if (val.id > newId) {
            newId = val.id
          }
        })

        newId++

        const contact : Contact = {
          id: newId,
          name: this.name,
          email: this.email,
          subject: this.subject,
          message: this.message,
          solved: false
        }
        this.contactService.add(contact)
          .subscribe(() => {
            this.router.navigate(['/contact'])
            this.name = ''
            this.email = ''
            this.subject = ''
            this.message = ''
            alert("Vaša správa bola zaznamenaná")
          })
      })


  }
}
