import {Author} from "./author";

export interface Book {
  id: number
  isbn: string
  title: string
  releaseYear: number
  numberOfPages: number
  info: string
  authors: Author[]
}
