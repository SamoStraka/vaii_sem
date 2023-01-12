import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Genre} from "./genre";

@Injectable({
  providedIn: 'root'
})
export class GenresService {

  constructor(private readonly http: HttpClient) { }

  get(id: number) {
    return this.http.get<Genre>(`/api/genre/${id}`)
  }

  getAll() {
    return this.http.get<Genre[]>('/api/genre')
  }

  add(genre: Genre) {
    return this.http.post<number>('/api/genre', genre)
  }

  delete(genre: Genre) {
    return this.http.delete<void>(`/api/genre/${genre.id}`)
  }

  edit(genre: Genre) {
    return this.http.put<void>(`/api/genre/${genre.id}`, genre)
  }
}
