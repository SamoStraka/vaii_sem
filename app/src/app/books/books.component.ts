import { Component, OnInit } from '@angular/core';
import {BooksService} from "../books.service";
import {Book} from "../book";

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = []

  constructor(
    private readonly bookService: BooksService,
  ) {
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
}
