import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Academic} from '../entity/academic';

@Injectable({
  providedIn: 'root'
})

export class AcademicService extends BaseService<Academic> {

  constructor(private http: HttpClient) {
    super(http, '/academic');
  }
}
