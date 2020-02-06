import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ActiveSpeciality} from '../entity/active-speciality';
import {Section} from '../entity/section';

@Injectable({
  providedIn: 'root'
})

export class SectionService extends BaseService<Section>{

  constructor(private http: HttpClient){
    super(http, "/section");
  }
}
