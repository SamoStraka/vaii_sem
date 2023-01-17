import { Component, OnInit } from '@angular/core';
import {Author} from "../author";
import {AuthorsService} from "../authors.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-author',
  templateUrl: './edit-author.component.html',
  styleUrls: ['./edit-author.component.css']
})
export class EditAuthorComponent implements OnInit {
  private id: number
  author: Author

  constructor(private readonly authorService: AuthorsService,
              private route: ActivatedRoute,
              private router: Router) {
    this.id = Number(route.snapshot.paramMap.get('id'))

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

  submit(form: any) {
    if (form.invalid) {
      return
    }

    this.authorService.edit(this.author)
      .subscribe(() => {
        this.router.navigate(['/authors', this.author.id, 'detail'])
      })
  }
}
