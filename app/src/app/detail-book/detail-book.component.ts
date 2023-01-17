import {Component} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BooksService} from "../books.service";
import {Book} from "../book";
import {ReservationsService} from "../reservations.service";

@Component({
  selector: 'app-detail-book',
  templateUrl: './detail-book.component.html',
  styleUrls: ['./detail-book.component.css']
})
export class DetailBookComponent {

  private id: number
  book = {} as Book
  reservationLength: number = 0
  more: boolean = false

  constructor(
    private readonly bookService: BooksService,
    private readonly reservationService: ReservationsService,
    private route: ActivatedRoute) {
    this.id = Number(route.snapshot.paramMap.get('id'));

    this.reservationLength = this.getReservedLength()

    bookService.get(this.id)
      .subscribe(value => {
        this.book = value
      })

  }

  addToReservation(): void {
    this.book.available--
    const start = localStorage.getItem('reservedBooks') == null ? '' : localStorage.getItem('reservedBooks') + ' '
    localStorage.setItem('reservedBooks',  start + this.book.id)
    this.reservationLength = this.getReservedLength()
    this.bookService.edit(this.book)
      .subscribe()
  }

  cutString(text:string, lenght: number): string {
    return text.length > lenght ? text.substring(0, lenght) + '...' : text
  }

  show(): void {
    this.more = !this.more
  }

  private getReservedLength(): number {
    const item = localStorage.getItem('reservedBooks')
    if (item == null || item.length == 0) {
      return 0
    }
    return (item?.split(' ') || []).length
  }


}
