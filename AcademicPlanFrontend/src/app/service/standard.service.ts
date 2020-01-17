import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Standard} from '../entity/standard';

@Injectable({
  providedIn: 'root'
})

export class StandardService extends BaseService<Standard> {

  constructor(private http: HttpClient) {
    super(http, '/standard');
  }

}
