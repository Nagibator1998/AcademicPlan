import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import {RouterModule, Routes} from '@angular/router';
import { CreatePlanComponent } from './component/create-plan/create-plan.component';
import { JumbotronComponent } from './component/jumbotron/jumbotron.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { SubjectComponent } from './component/subject/subject.component';

const routes: Routes = [
  {path: '', redirectTo: 'jumbotron', pathMatch: 'full'},
  {path: 'create-plan', component: CreatePlanComponent},
  {path: 'jumbotron', component: JumbotronComponent},
  {path: '*', redirectTo: '/'}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CreatePlanComponent,
    JumbotronComponent,
    SubjectComponent
  ],
  exports: [RouterModule],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
