import {Author} from "./author";
import {Genre} from "./genre";
import {Language} from "./language";

export interface Book {
  id: number
  isbn: string
  title: string
  releaseYear: number
  numberOfPages: number
  info: string
  authors: Author[]
  bookGenres: Genre[]
  language: Language
}
