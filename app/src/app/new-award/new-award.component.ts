import { Component, OnInit } from '@angular/core';
import {AwardsService} from "../awards.service";
import {Award} from "../award";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-award',
  templateUrl: './new-award.component.html',
  styleUrls: ['./new-award.component.css']
})
export class NewAwardComponent implements OnInit {

  name: string = ''
  priority: number = 3
  options: any[] = [
    {value: 1, name: 'Vysoká'},
    {value: 2, name: 'Stredná'},
    {value: 3, name: 'Nízka'}
  ]

  constructor(
    private readonly awardService: AwardsService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  submit(form: any) {
    if (form.invalid) {
      return
    }
    let newId: number = 0
    this.awardService.getAll()
      .subscribe(value => {
        value.forEach(val => {
          if (val.id > newId) {
            newId = val.id
          }
        })

        newId++

        const award : Award = {
          id: newId,
          name: this.name,
          priority: this.priority
        }
        this.awardService.add(award)
          .subscribe(() => {
            this.router.navigate(['/home'])
            alert("Ocenenie pridané!")
          })
      })


  }
}
