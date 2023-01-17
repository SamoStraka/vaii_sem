import {Author} from "./author";
import {Genre} from "./genre";
import {Language} from "./language";
import {Reservation} from "./reservation";

export interface Book {
  id: number
  isbn: string
  title: string
  releaseYear: number
  numberOfPages: number
  info: string
  available: number
  authors: Author[]
  bookGenres: Genre[]
  language: Language
  bookReservations: Reservation[]
}
