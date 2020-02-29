import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {CourseProject} from '../entity/course-project';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CourseProjectService extends BaseService<CourseProject>{

  constructor(private http: HttpClient){
    super(http, "/courseProject");
  }

  getByExplanatoryNoteId(explanatoryNoteId: number): Observable<CourseProject>{
    return this.http.get<CourseProject>('/api/courseProject/byExplanatoryNoteId/' + explanatoryNoteId);
  }
}
