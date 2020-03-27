import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ControlQuestion} from '../entity/control-question';

@Injectable({
  providedIn: 'root'
})

export class ControlQuestionService extends BaseService<ControlQuestion>{

  constructor(private http: HttpClient){
    super(http, "/controlQuestion");
  }
}
