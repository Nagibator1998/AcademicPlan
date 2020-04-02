import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Literature} from '../entity/literature';

@Injectable({
  providedIn: 'root'
})

export class LiteratureService extends BaseService<Literature> {

  constructor(private http: HttpClient) {
    super(http, '/literature');
  }
}
