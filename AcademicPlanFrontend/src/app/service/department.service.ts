import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Department} from '../entity/department';

@Injectable({
  providedIn: 'root'
})

export class DepartmentService extends BaseService<Department> {

  constructor(private http: HttpClient) {
    super(http, '/department');
  }
}
