import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Academic} from '../entity/academic';
import {AcademicDegree} from '../entity/academic-degree';

@Injectable({
  providedIn: 'root'
})

export class AcademicDegreeService extends BaseService<AcademicDegree> {

  constructor(private http: HttpClient) {
    super(http, '/academicDegree');
  }
}
