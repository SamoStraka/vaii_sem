import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contact} from "./contact";

@Injectable({
  providedIn: 'root'
})
export class ContactsService {

  constructor(private readonly http: HttpClient) { }

  getAll() {
    return this.http.get<Contact[]>('/api/contact')
  }

  add(contact: Contact) {
    return this.http.post<number>('/api/contact', contact)
  }

  delete(contact: Contact) {
    return this.http.delete<void>(`/api/contact/${contact.id}`)
  }

  edit(contact: Contact) {
    return this.http.put<void>(`/api/contact/${contact.id}`, contact)
  }
}
