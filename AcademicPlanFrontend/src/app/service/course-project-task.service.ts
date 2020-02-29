import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {CourseProjectTask} from '../entity/course-project-task';

@Injectable({
  providedIn: 'root'
})

export class CourseProjectTaskService extends BaseService<CourseProjectTask>{

  constructor(private http: HttpClient){
    super(http, "/courseProjectTask");
  }

}
