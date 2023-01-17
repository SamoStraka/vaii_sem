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
import {UsersGuard} from "./users.guard";
import {ContactsManageComponent} from "./contacts-manage/contacts-manage.component";
import {DetailBookComponent} from "./detail-book/detail-book.component";
import {DetailReservationComponent} from "./detail-reservation/detail-reservation.component";
import {ReservationManageComponent} from "./reservation-manage/reservation-manage.component";


const routes: Routes = [
  {path:'index', component: IndexPageComponent},
  {path:'home', component: HomeComponent},
  {path:'home/new-award', component: NewAwardComponent, canActivate: [UsersGuard]},
  {path:'books', component: BooksComponent},
  {path:'books/new', component: NewBookComponent, canActivate: [UsersGuard]},
  {path:'books/:id/edit', component: EditBookComponent, canActivate: [UsersGuard]},
  {path:'books/:id/detail', component: DetailBookComponent},
  {path:'reservation', component: DetailReservationComponent},
  {path:'reservation/manage', component: ReservationManageComponent, canActivate: [UsersGuard]},
  {path:'authors', component: AuthorsComponent},
  {path:'authors/new', component: NewAuthorComponent, canActivate: [UsersGuard]},
  {path:'authors/:id/edit', component: EditAuthorComponent, canActivate: [UsersGuard]},
  {path:'authors/:id/detail', component: DetailAuthorComponent},
  {path:'contact', component: ContactComponent},
  {path:'contact/manage', component: ContactsManageComponent, canActivate: [UsersGuard]},
  {path:'login', component: LoginComponent},
  {path:'logout', component: HomeComponent},
  {path:'', redirectTo: 'index', pathMatch: 'full'},
  {path:'**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
