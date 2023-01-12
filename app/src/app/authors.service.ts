import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Author} from "./author";

@Injectable({
  providedIn: 'root'
})
export class AuthorsService {

  constructor(private readonly http: HttpClient) {}

  get(id: number) {
    return this.http.get<Author>(`/api/author/${id}`)
  }

  getAll() {
    return this.http.get<Author[]>('/api/author')
  }

  add(author: Author) {
    return this.http.post<number>('/api/author', author)
  }

  delete(author: Author) {
    return this.http.delete<void>(`/api/author/${author.id}`)
  }

  edit(author: Author) {
    return this.http.put<void>(`/api/author/${author.id}`, author)
  }
}
