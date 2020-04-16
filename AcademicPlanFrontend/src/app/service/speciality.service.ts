import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Speciality} from '../entity/speciality';

@Injectable({
  providedIn: 'root'
})

export class SpecialityService extends BaseService<Speciality> {

  constructor(private http: HttpClient) {
    super(http, '/speciality');
  }

}
