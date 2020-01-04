import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import {RouterModule, Routes} from '@angular/router';
import { CreatePlanComponent } from './component/create-plan/create-plan.component';
import { JumbotronComponent } from './component/jumbotron/jumbotron.component';

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
    JumbotronComponent
  ],
  exports: [RouterModule],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
