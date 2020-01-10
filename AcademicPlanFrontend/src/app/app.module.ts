import { BrowserModule } from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import {RouterModule, Routes} from '@angular/router';
import { CreatePlanComponent } from './component/create-plan/create-plan.component';
import { JumbotronComponent } from './component/jumbotron/jumbotron.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { SubjectComponent } from './component/subject/subject.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AutocompleteLibModule} from 'angular-ng-autocomplete';
import {Constants} from './const/constants';
import { ActiveSpecialityComponent } from './component/active-speciality/active-speciality.component';


const routes: Routes = [
  {path: '', redirectTo: Constants.JUMBOTRON_ROUTE_PATH, pathMatch: 'full'},
  {path: Constants.CREATE_PLAN_ROUTE_PATH, component: CreatePlanComponent},
  {path: Constants.JUMBOTRON_ROUTE_PATH, component: JumbotronComponent},
  {path: Constants.SUBJECT_ROUTE_PATH, component: SubjectComponent},
  {path: Constants.ACTIVE_SPECIALITY_ROUTE_PATH, component: ActiveSpecialityComponent},
  {path: '*', redirectTo: '/'}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CreatePlanComponent,
    JumbotronComponent,
    SubjectComponent,
    ActiveSpecialityComponent
  ],
  exports: [RouterModule],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    AutocompleteLibModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
