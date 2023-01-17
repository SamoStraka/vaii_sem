import {Book} from "./book";

export interface Reservation {
  id: number
  email: string
  number: number
  reservationBooks: Book[]
}
