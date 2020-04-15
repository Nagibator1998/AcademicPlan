import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Faculty} from '../entity/faculty';

@Injectable({
  providedIn: 'root'
})

export class FacultyService extends BaseService<Faculty> {

  constructor(private http: HttpClient) {
    super(http, '/faculty');
  }
}
