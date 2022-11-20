import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthorsComponent} from "./authors/authors.component";


const routes: Routes = [
  {path:'authors', component: AuthorsComponent},
  {path:'', redirectTo: 'about', pathMatch: 'full'},
  {path:'**', component: AuthorsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
