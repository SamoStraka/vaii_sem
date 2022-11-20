import {Book} from "./book";

export interface Author {
  id: number
  name: string
  lastName: string
  info: string
  authorBooks: Book[]
}
