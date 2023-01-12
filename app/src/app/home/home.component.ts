import { Component, OnInit } from '@angular/core';
import {AuthorsService} from "../authors.service";
import {BooksService} from "../books.service";
import {GenresService} from "../genres.service";
import {AwardsService} from "../awards.service";
import {Award} from "../award";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  authorsCount:number = 0
  booksCount:number = 0
  genresCount:number = 0
  awards: Award[] = []

  constructor(
    private readonly authorService: AuthorsService,
    private readonly bookService: BooksService,
    private readonly genreService: GenresService,
    private readonly awardService: AwardsService
  ) {
    this.authorService.getAll()
      .subscribe(value => {
        this.authorsCount = value.length
      })

    this.bookService.getAll()
      .subscribe(value => {
        this.booksCount = value.length
      })

    this.genreService.getAll()
      .subscribe(value => {
        this.genresCount = value.length
      })

    this.fetchAwards()
  }

  ngOnInit(): void {
  }

  delete(award: Award) {
    if(confirm(`Odstrániť ocenenie ${award.name}?`)) {
      this.awardService.delete(award)
        .subscribe(() => {
          this.fetchAwards()
        })
    }
  }

  private fetchAwards() {
    this.awardService.getAll()
      .subscribe(value =>  {
        this.awards = value
      })
  }

}
