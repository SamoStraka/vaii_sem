import {Component, OnDestroy, OnInit} from '@angular/core';
import {ContactsService} from "../contacts.service";
import {Contact} from "../contact";
import {Observable} from "rxjs";
import {User} from "../user";
import {UsersService} from "../users.service";

@Component({
  selector: 'app-contacts-manage',
  templateUrl: './contacts-manage.component.html',
  styleUrls: ['./contacts-manage.component.css']
})
export class ContactsManageComponent {

  contacts: Contact[] = []
  user$: Observable<User | undefined>
  allOptions: boolean = true

  constructor(
    private readonly contactService: ContactsService,
    private readonly userService: UsersService
  ) {
    this.user$ = userService.onUserChange()
    this.fetchContacts()

  }

    delete(contact: Contact) {
    this.contactService.delete(contact)
      .subscribe(() => {
        this.fetchContacts()
      })
  }

  solve(contact: Contact) {
    contact.solved = !contact.solved
    this.contactService.edit(contact)
      .subscribe()
  }

  showAll() {
    this.allOptions = !this.allOptions
  }

  private fetchContacts() {
    this.contactService.getAll()
      .subscribe(value => {
        this.contacts = value
      })
  }

}
