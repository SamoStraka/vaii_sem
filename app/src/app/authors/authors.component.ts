import { Component, OnInit } from '@angular/core';
import {AuthorsService} from "../authors.service";
import {Author} from "../author";

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})
export class AuthorsComponent implements OnInit {

  authors: Author[] = []

  constructor(private readonly authorService: AuthorsService) {
   this.reload()
  }

  private reload() {
    this.authorService.getAll()
      .subscribe(value => {
       this.authors = value
      })
  }

  ngOnInit(): void {
  }

  cutString(text:string): string {
    return text.length > 180 ? text.substring(0, 180) + '...' : text
  }

  delete(author:Author) {
      if(confirm(`Odstrániť autora ${author.name} ${author.lastName}?`)) {
        this.authorService.delete(author)
          .subscribe(() => {
            this.reload()
          })
      }
  }
}
