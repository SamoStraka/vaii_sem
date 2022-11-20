import { Component, OnInit } from '@angular/core';
import {AuthorsService} from "../authors.service";
import {Author} from "../author";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-author',
  templateUrl: './new-author.component.html',
  styleUrls: ['./new-author.component.css']
})
export class NewAuthorComponent implements OnInit {

  name: string = ''
  lastName: string = ''
  info: string = ''

  constructor(private readonly authorService: AuthorsService,
              private router: Router) {

  }

  ngOnInit(): void {
  }

  submit(form: any) {
    if (form.invalid) {
      return
    }
    let newId: number = 0
    this.authorService.getAll()
      .subscribe(value => {
        value.forEach(val => {
          if (val.id > newId) {
            newId = val.id
          }
          console.log('new' + newId)
          console.log('val' + val.id)
        })

        newId++

        const author : Author = {
          id: newId,
          name: this.name,
          lastName: this.lastName,
          info: this.info,
          authorBooks: []
        }
        this.authorService.add(author)
          .subscribe(() => {
            this.router.navigate(['/authors'])
            alert("Autor pridaný!")
          })
      })


  }

}
