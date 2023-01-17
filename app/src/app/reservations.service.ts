import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Reservation} from "./reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  constructor(private readonly http: HttpClient) { }

  get(id: number) {
    return this.http.get<Reservation>(`/api/reservation/${id}`)
  }

  getAll() {
    return this.http.get<Reservation[]>('/api/reservation')
  }

  add(reservation: Reservation) {
    return this.http.post<number>('/api/reservation', reservation)
  }

  delete(reservation: Reservation) {
    return this.http.delete<void>(`/api/reservation/${reservation.id}`)
  }

  edit(reservation: Reservation) {
    return this.http.put<void>(`/api/reservation/${reservation.id}`, reservation)
  }
}
