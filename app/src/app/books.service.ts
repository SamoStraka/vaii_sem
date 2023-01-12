import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "./book";

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(private readonly http: HttpClient) { }

  get(id: number) {
    return this.http.get<Book>(`/api/book/${id}`)
  }

  getAll() {
    return this.http.get<Book[]>('/api/book')
  }

  add(book: Book) {
    return this.http.post<number>('/api/book', book)
  }

  delete(book: Book) {
    return this.http.delete<void>(`/api/book/${book.id}`)
  }

  edit(book: Book) {
    return this.http.put<void>(`/api/book/${book.id}`, book)
  }
}
