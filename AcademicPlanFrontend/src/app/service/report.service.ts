import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class ReportService {

  constructor(private httpClient: HttpClient){}

  public get(explanatoryNoteId: number): Observable<string> {
    return this.httpClient.get<string>('/api/report/' + explanatoryNoteId);
  }


}
