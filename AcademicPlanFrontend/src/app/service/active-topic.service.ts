import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ActiveTopic} from '../entity/active-topic';

@Injectable({
  providedIn: 'root'
})

export class ActiveTopicService extends BaseService<ActiveTopic>{

  constructor(private http: HttpClient){
    super(http, "/activeTopic");
  }
}
