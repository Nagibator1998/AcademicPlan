import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {LaboratoryWork} from '../entity/laboratory-work';

@Injectable({
  providedIn: 'root'
})

export class LaboratoryWorkService extends BaseService<LaboratoryWork>{

  constructor(private http: HttpClient){
    super(http, "/laboratoryWork");
  }
}
