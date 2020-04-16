import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Injectable} from '@angular/core';
import {Position} from '../entity/position';

@Injectable({
  providedIn: 'root'
})

export class PositionService extends BaseService<Position> {

  constructor(private http: HttpClient) {
    super(http, '/position');
  }
}
