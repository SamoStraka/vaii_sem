import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthorsComponent} from "./authors/authors.component";
import {HomeComponent} from "./home/home.component";
import {BooksComponent} from "./books/books.component";
import {ContactComponent} from "./contact/contact.component";
import {IndexPageComponent} from "./index-page/index-page.component";


const routes: Routes = [
  {path:'index', component: IndexPageComponent},
  {path:'home', component: HomeComponent},
  {path:'books', component: BooksComponent},
  {path:'authors', component: AuthorsComponent},
  {path:'contact', component: ContactComponent},
  {path:'', redirectTo: 'index', pathMatch: 'full'},
  {path:'**', component: AuthorsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
