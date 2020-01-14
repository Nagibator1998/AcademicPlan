import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {CourseProject} from '../entity/course-project';

@Injectable({
  providedIn: 'root'
})

export class CourseProjectService extends BaseService<CourseProject>{

  constructor(private http: HttpClient){
    super(http, "/courseProject");
  }
}
