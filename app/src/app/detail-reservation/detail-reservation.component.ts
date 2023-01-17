import { Component, OnInit } from '@angular/core';
import {ReservationsService} from "../reservations.service";
import {BooksService} from "../books.service";
import {Book} from "../book";
import {Reservation} from "../reservation";
import {Router} from "@angular/router";

@Component({
  selector: 'app-detail-reservation',
  templateUrl: './detail-reservation.component.html',
  styleUrls: ['./detail-reservation.component.css']
})
export class DetailReservationComponent implements OnInit {

  count: number = 0
  books: Book[] = []
  email: string = ''

  constructor(
    private readonly reservationService: ReservationsService,
    private readonly bookService: BooksService,
    private router: Router
  ) {

    const item = localStorage.getItem('reservedBooks')
    if (item != null && item.length != 0) {
      const storage = item?.split(' ')
      this.count = (storage || []).length
      storage.forEach(value => {
        this.bookService.get(Number(value))
          .subscribe(val => {
            this.books.push(val)
          })
      })
    } else {
      this.count = 0
    }
  }

  ngOnInit(): void {
  }

  remove(book: Book) {
    let item = localStorage.getItem('reservedBooks')
    if (item != null) {
      book.available++
      item = item.replace(String(book.id), '')
      item = item.trim()
      localStorage.setItem('reservedBooks', item)
      this.count--
    }
    this.bookService.edit(book)
      .subscribe()
    this.books = this.books.filter(value => value.id != book.id)
  }

  confirm(): void {
    let newId: number = 0
    let newNumber: number = 100000
    this.reservationService.getAll()
      .subscribe(value => {
        value.forEach(val => {
          if (val.id > newId) {
            newId = val.id
          }
          if (val.number > newNumber) {
            newNumber = val.number
          }
        })


        newId++
        newNumber++

        const reservation: Reservation = {
          id: newId,
          email: this.email,
          number: newNumber,
          reservationBooks: this.books
        }
        this.reservationService.add(reservation)
          .subscribe(() => {
            localStorage.setItem('reservedBooks', '')
            this.router.navigate(['/books'])
            alert("Rezervácia potvrdená!")
          })
      })
  }
}
