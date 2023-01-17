import { Component } from '@angular/core';
import {ReservationsService} from "../reservations.service";
import {Reservation} from "../reservation";
import {Observable} from "rxjs";
import {User} from "../user";
import {UsersService} from "../users.service";
import {BooksService} from "../books.service";

@Component({
  selector: 'app-reservation-manage',
  templateUrl: './reservation-manage.component.html',
  styleUrls: ['./reservation-manage.component.css']
})
export class ReservationManageComponent {

  reservations: Reservation[] = []
  user$: Observable<User | undefined>

  constructor(
    private readonly reservationService: ReservationsService,
    private readonly bookService: BooksService,
    private readonly userService: UsersService
  ) {
    this.user$ = userService.onUserChange()
    this.fetch()
  }

  delete(reservation: Reservation) {
    reservation.reservationBooks.forEach(value => {
      value.available++
      this.bookService.edit(value)
        .subscribe()
    })
    this.reservationService.delete(reservation)
      .subscribe(() => {
        this.fetch()
      })
  }

  private fetch() {
    this.reservationService.getAll()
      .subscribe(value => {
        this.reservations = value
      })
  }

}
