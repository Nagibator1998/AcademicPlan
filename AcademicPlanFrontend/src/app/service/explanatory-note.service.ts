import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ExplanatoryNote} from '../entity/explanatory-note';

@Injectable({
  providedIn: 'root'
})

export class ExplanatoryNoteService extends BaseService<ExplanatoryNote>{

  constructor(private http: HttpClient){
    super(http, "/explanatoryNote");
  }
}
