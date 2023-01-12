import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Award} from "./award";

@Injectable({
  providedIn: 'root'
})
export class AwardsService {

  constructor(private readonly http: HttpClient) {}

  get(id: number) {
    return this.http.get<Award>(`/api/award/${id}`)
  }

  getAll() {
    return this.http.get<Award[]>('/api/award')
  }

  add(award: Award) {
    return this.http.post<number>('/api/award', award)
  }

  delete(award: Award) {
    return this.http.delete<void>(`/api/award/${award.id}`)
  }
}
