import { Component, OnInit } from '@angular/core';
import { Author } from "../author";
import { AuthorsService } from "../authors.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-detail-author',
  templateUrl: './detail-author.component.html',
  styleUrls: ['./detail-author.component.css']
})
export class DetailAuthorComponent implements OnInit {

  private id: number;
  author: Author;

  constructor(private readonly authorService: AuthorsService,
              private route: ActivatedRoute) {
    this.id = Number(route.snapshot.paramMap.get('id'));

    this.author = {
      id: this.id,
      name: '',
      lastName: '',
      info: '',
      authorBooks: []
    }

    authorService.get(this.id)
      .subscribe(value => {
        this.author = value
      })
  }

  ngOnInit(): void {
  }

}
