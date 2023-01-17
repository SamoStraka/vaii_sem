import { Component, OnInit } from '@angular/core';
import { Author } from "../author";
import { AuthorsService } from "../authors.service";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-detail-author',
  templateUrl: './detail-author.component.html',
  styleUrls: ['./detail-author.component.css']
})
export class DetailAuthorComponent{

  private id: number
  more: boolean = false
  author = {} as Author

  constructor(private readonly authorService: AuthorsService,
              private route: ActivatedRoute) {
    this.id = Number(route.snapshot.paramMap.get('id'));

    authorService.get(this.id)
      .subscribe(value => {
        this.author = value
      })
  }
  cutString(text:string, lenght: number): string {
    return text.length > lenght ? text.substring(0, lenght) + '...' : text
  }

  show(): void {
    this.more = !this.more
  }

}
