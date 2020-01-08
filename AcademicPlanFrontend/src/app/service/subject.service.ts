import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Subject} from '../entity/subject';

@Injectable({
  providedIn: 'root'
})

export class SubjectService extends BaseService<Subject>{

  constructor(private http: HttpClient){
    super(http, "/subject");
  }
}
