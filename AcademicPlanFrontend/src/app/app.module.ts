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
import { AcademicComponent } from './component/academic/academic.component';
import { StandardComponent } from './component/standard/standard.component';
import { ExplanatoryNoteComponent } from './component/explanatory-note/explanatory-note.component';
import { CompetenceComponent } from './component/competence/competence.component';


const routes: Routes = [
  {path: '', redirectTo: Constants.JUMBOTRON_ROUTE_PATH, pathMatch: 'full'},
  {path: Constants.CREATE_PLAN_ROUTE_PATH, component: CreatePlanComponent},
  {path: Constants.JUMBOTRON_ROUTE_PATH, component: JumbotronComponent},
  {path: Constants.SUBJECT_ROUTE_PATH, component: SubjectComponent},
  {path: Constants.ACTIVE_SPECIALITY_ROUTE_PATH, component: ActiveSpecialityComponent},
  {path: Constants.ACADEMIC_ROUTE_PATH, component: AcademicComponent},
  {path: Constants.STANDARD_ROUTE_PATH, component: StandardComponent},
  {path: Constants.EXPLANATORY_NOTE_ROUTE_PATH, component: ExplanatoryNoteComponent},
  {path: Constants.COMPETENCE_ROUTE_PATH, component: CompetenceComponent},
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
    ActiveSpecialityComponent,
    AcademicComponent,
    StandardComponent,
    ExplanatoryNoteComponent,
    CompetenceComponent
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
