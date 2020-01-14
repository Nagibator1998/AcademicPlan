import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ActiveSpeciality} from '../entity/active-speciality';

@Injectable({
  providedIn: 'root'
})

export class ActiveSpecialityService extends BaseService<ActiveSpeciality>{

  constructor(private http: HttpClient){
    super(http, "/activeSpeciality");
  }
}
