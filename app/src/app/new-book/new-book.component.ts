import { Component, OnInit } from '@angular/core';
import {AuthorsService} from "../authors.service";
import {Router} from "@angular/router";
import {Author} from "../author";
import {BooksService} from "../books.service";
import {Book} from "../book";
import {Genre} from "../genre";
import {GenresService} from "../genres.service";
import {Language} from "../language";
import {LanguagesService} from "../languages.service";

@Component({
  selector: 'app-new-book',
  templateUrl: './new-book.component.html',
  styleUrls: ['./new-book.component.css']
})
export class NewBookComponent implements OnInit {

  title: string = ''
  isbn: string = ''
  releaseYear: number = new Date().getFullYear()
  numberOfPages: number = 0
  info: string = ''
  genres: Genre[] = []
  selectedGenres: Genre[] = []
  selectedGenre: number = 0
  authors: Author[] = []
  selectedAuthors: Author[] = []
  selectedAuthor: number = 0
  languageId: number = 0
  languageOptions : Language[] = []

  constructor(
    private readonly bookService: BooksService,
    private readonly authorService: AuthorsService,
    private readonly genreService: GenresService,
    private readonly languagesService: LanguagesService,
    private router: Router) {

    this.languagesService.getAll()
      .subscribe(value => {
        this.languageOptions = value
      })

    if (this.languageOptions.length > 0) {
      this.languageId = this.languageOptions[0].id
    }

    this.authorService.getAll()
      .subscribe(value => {
        this.authors = value
      })

    if (this.authors.length > 0) {
      this.selectedAuthor = this.authors[0].id
    }

    this.genreService.getAll()
      .subscribe(value => {
        this.genres = value
      })

    if (this.genres.length > 0) {
      this.selectedGenre = this.genres[0].id
    }
  }

  ngOnInit(): void {
  }

  selectAuthor() {
    const author = this.authors.find(x => x.id == this.selectedAuthor)
    if (author !== undefined && !this.selectedAuthors.includes(author)) {
      this.selectedAuthors.push(author)
    }
  }

  selectGenre() {
    const genre = this.genres.find(x => x.id == this.selectedGenre)
    if (genre !== undefined && !this.selectedGenres.includes(genre)) {
      this.selectedGenres.push(genre)
    }
  }

  submit(form: any) {
    if (form.invalid) {
      return
    }
    let newId: number = 0
    this.bookService.getAll()
      .subscribe(value => {
        value.forEach(val => {
          if (val.id > newId) {
            newId = val.id
          }
        })

        newId++
        let language = this.languageOptions.find(x => x.id == this.languageId)
        language = language === undefined ? {id:1, name:'Slovenský'}: language

        const book : Book = {
          id: newId,
          isbn: this.isbn,
          title: this.title,
          releaseYear: this.releaseYear,
          numberOfPages: this.numberOfPages,
          info: this.info,
          authors: this.selectedAuthors,
          bookGenres: this.selectedGenres,
          language: language
        }
        this.bookService.add(book)
          .subscribe(() => {
            this.router.navigate(['/books'])
            alert("Kniha pridaná!")
          })
      })
  }

  removeFromSelectedAuthors(author: Author) {
    const index = this.selectedAuthors.findIndex(a => a.id == author.id);
    this.selectedAuthors.splice(index, 1);
  }

  removeFromSelectedGenres(genre: Genre) {
    const index = this.selectedGenres.findIndex(a => a.id == genre.id);
    this.selectedGenres.splice(index, 1);
  }
}
