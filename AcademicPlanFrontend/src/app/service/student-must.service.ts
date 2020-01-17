import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {StudentMust} from '../entity/student-must';

@Injectable({
  providedIn: 'root'
})

export class StudentMustService extends BaseService<StudentMust>{

  constructor(private http: HttpClient){
    super(http, "/studentMust");
  }
}
