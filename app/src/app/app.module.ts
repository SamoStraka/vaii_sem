import {LOCALE_ID, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AuthorsComponent } from './authors/authors.component';
import {AppRoutingModule} from "./app-routing.module";
import { HomeComponent } from './home/home.component';
import { BooksComponent } from './books/books.component';
import { ContactComponent } from './contact/contact.component';
import { IndexPageComponent } from './index-page/index-page.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { NewAuthorComponent } from './new-author/new-author.component';
import {FormsModule} from "@angular/forms";
import { EditAuthorComponent } from './edit-author/edit-author.component';
import { DetailAuthorComponent } from './detail-author/detail-author.component';
import { NewAwardComponent } from './new-award/new-award.component';
import { NewBookComponent } from './new-book/new-book.component';
import { EditBookComponent } from './edit-book/edit-book.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {UsersInterceptor} from "./users.interceptor";
import { ContactsManageComponent } from './contacts-manage/contacts-manage.component';
import { DetailBookComponent } from './detail-book/detail-book.component';
import { DetailReservationComponent } from './detail-reservation/detail-reservation.component';
import { ReservationManageComponent } from './reservation-manage/reservation-manage.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthorsComponent,
    HomeComponent,
    BooksComponent,
    ContactComponent,
    IndexPageComponent,
    NewAuthorComponent,
    EditAuthorComponent,
    DetailAuthorComponent,
    NewAwardComponent,
    NewBookComponent,
    EditBookComponent,
    LoginComponent,
    NotFoundComponent,
    ContactsManageComponent,
    DetailBookComponent,
    DetailReservationComponent,
    ReservationManageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'sk'},
    {provide: HTTP_INTERCEPTORS, useClass: UsersInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
