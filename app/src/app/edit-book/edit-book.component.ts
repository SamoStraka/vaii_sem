import { Component, OnInit } from '@angular/core';
import {Genre} from "../genre";
import {Author} from "../author";
import {Language} from "../language";
import {BooksService} from "../books.service";
import {AuthorsService} from "../authors.service";
import {GenresService} from "../genres.service";
import {LanguagesService} from "../languages.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Book} from "../book";

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
  private id: number
  book = {} as Book
  genres: Genre[] = []
  selectedGenre: number = 0
  authors: Author[] = []
  selectedAuthor: number = 0
  languageId: number = 0
  languageOptions: Language[] = []

  constructor(
    private readonly bookService: BooksService,
    private readonly authorService: AuthorsService,
    private readonly genreService: GenresService,
    private readonly languagesService: LanguagesService,
    private route: ActivatedRoute,
    private router: Router) {

    this.id = Number(route.snapshot.paramMap.get('id'))

    this.bookService.get(this.id)
      .subscribe(value => {
        this.book = value
      })

    this.languagesService.getAll()
      .subscribe(value => {
        this.languageOptions = value
      })

    this.authorService.getAll()
      .subscribe(value => {
        this.authors = value
      })

    this.genreService.getAll()
      .subscribe(value => {
        this.genres = value
      })

  }

  ngOnInit(): void {
  }

  selectAuthor() {
    const author = this.authors.find(x => x.id == this.selectedAuthor)
    const existing = this.book.authors.find(x => x.id == this.selectedAuthor)
    if (author !== undefined && existing === undefined) {
      this.book.authors.push(author)
    }
  }

  selectGenre() {
    const genre = this.genres.find(x => x.id == this.selectedGenre)
    const existing = this.book.bookGenres.find(x => x.id == this.selectedGenre)
    if (genre !== undefined && existing === undefined) {
      this.book.bookGenres.push(genre)
    }
  }

  submit(form: any) {
    if (form.invalid) {
      return
    }

    const language = this.languageOptions.find(x => x.id == this.languageId)
    if (language !== undefined) {
      this.book.language = language
    }

    this.bookService.edit(this.book)
      .subscribe(() => {
        this.router.navigate(['/books', this.book.id, 'detail'])
      })
  }

  removeFromSelectedAuthors(author: Author) {
    const index = this.book.authors.findIndex(a => a.id == author.id);
    this.book.authors.splice(index, 1);
  }

  removeFromSelectedGenres(genre: Genre) {
    const index = this.book.bookGenres.findIndex(a => a.id == genre.id);
    this.book.bookGenres.splice(index, 1);
  }
}
