import { Component, OnInit } from '@angular/core';
import {BooksService} from "../books.service";
import {Book} from "../book";
import {UsersService} from "../users.service";
import {Observable} from "rxjs";
import {User} from "../user";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = []
  reservationLength: number = 0
  user$: Observable<User | undefined>

  constructor(
    private readonly bookService: BooksService,
    private readonly userService: UsersService
  ) {
    this.reservationLength = this.getReservedLength()
    this.user$ = userService.onUserChange()
    this.fetch()
  }


  private fetch() {
    this.bookService.getAll()
      .subscribe(value => {
        this.books = value
      })
  }

  ngOnInit(): void {
  }

  cutString(text:string): string {
    return text.length > 180 ? text.substring(0, 180) + '...' : text
  }

  delete(book:Book) {
    if(confirm(`Odstrániť knihu ${book.title}?`)) {
      this.bookService.delete(book)
        .subscribe(() => {
          this.fetch()
        })
    }
  }

  private getReservedLength(): number {
    const item = localStorage.getItem('reservedBooks')
    if (item == null || item.length == 0) {
      return 0
    }
    return (item?.split(' ') || []).length
  }
}
