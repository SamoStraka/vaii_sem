import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AuthorsComponent } from './authors/authors.component';
import {AppRoutingModule} from "./app-routing.module";
import { HomeComponent } from './home/home.component';
import { BooksComponent } from './books/books.component';
import { ContactComponent } from './contact/contact.component';
import { IndexPageComponent } from './index-page/index-page.component';
import {HttpClientModule} from "@angular/common/http";
import { NewAuthorComponent } from './new-author/new-author.component';
import {FormsModule} from "@angular/forms";
import { EditAuthorComponent } from './edit-author/edit-author.component';
import { DetailAuthorComponent } from './detail-author/detail-author.component';
import { NewAwardComponent } from './new-award/new-award.component';

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
    NewAwardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
