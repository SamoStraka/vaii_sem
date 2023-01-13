import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Language} from "./language";

@Injectable({
  providedIn: 'root'
})
export class LanguagesService {
  constructor(private readonly http: HttpClient) { }

  getAll() {
    return this.http.get<Language[]>('/api/language')
  }
}
