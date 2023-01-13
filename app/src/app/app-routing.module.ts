import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthorsComponent} from "./authors/authors.component";
import {HomeComponent} from "./home/home.component";
import {BooksComponent} from "./books/books.component";
import {ContactComponent} from "./contact/contact.component";
import {IndexPageComponent} from "./index-page/index-page.component";
import {NewAuthorComponent} from "./new-author/new-author.component";
import {EditAuthorComponent} from "./edit-author/edit-author.component";
import {DetailAuthorComponent} from "./detail-author/detail-author.component";
import {NewAwardComponent} from "./new-award/new-award.component";
import {NewBookComponent} from "./new-book/new-book.component";
import {EditBookComponent} from "./edit-book/edit-book.component";
import {LoginComponent} from "./login/login.component";
import {NotFoundComponent} from "./not-found/not-found.component";


const routes: Routes = [
  {path:'index', component: IndexPageComponent},
  {path:'home', component: HomeComponent},
  {path:'home/new-award', component: NewAwardComponent},
  {path:'books', component: BooksComponent},
  {path:'books/new', component: NewBookComponent},
  {path:'books/:id/edit', component: EditBookComponent},
  {path:'authors', component: AuthorsComponent},
  {path:'authors/new', component: NewAuthorComponent},
  {path:'authors/:id/edit', component: EditAuthorComponent},
  {path:'authors/:id/detail', component: DetailAuthorComponent},
  {path:'contact', component: ContactComponent},
  {path:'login', component: LoginComponent},
  {path:'', redirectTo: 'index', pathMatch: 'full'},
  {path:'**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
