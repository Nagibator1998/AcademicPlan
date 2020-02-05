import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Competence} from '../entity/competence';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CompetenceService extends BaseService<Competence> {

  constructor(private http: HttpClient) {
    super(http, '/competence');
  }

  public getCompetencesForThisExplanatoryNote(explanatoryNoteId: number): Observable<Competence[]> {
    return this.http.get<Competence[]>('/api/competence/forExplanatoryNote/' + explanatoryNoteId);
  }
}
