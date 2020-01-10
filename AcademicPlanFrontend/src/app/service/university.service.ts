import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ExplanatoryNote} from '../entity/explanatory-note';
import {University} from '../entity/university';

@Injectable({
  providedIn: 'root'
})

export class UniversityService extends BaseService<University>{

  constructor(private http: HttpClient){
    super(http, "/university");
  }
}
