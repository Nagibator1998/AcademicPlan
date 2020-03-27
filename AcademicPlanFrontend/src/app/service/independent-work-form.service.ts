import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {LaboratoryWork} from '../entity/laboratory-work';
import {IndependentWorkForm} from '../entity/independent-work-form';

@Injectable({
  providedIn: 'root'
})

export class IndependentWorkFormService extends BaseService<IndependentWorkForm>{

  constructor(private http: HttpClient){
    super(http, "/independentWorkForm");
  }
}
