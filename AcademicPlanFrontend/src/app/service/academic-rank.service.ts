import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {Academic} from '../entity/academic';
import {AcademicDegree} from '../entity/academic-degree';
import {AcademicRank} from '../entity/academic-rank';

@Injectable({
  providedIn: 'root'
})

export class AcademicRankService extends BaseService<AcademicRank> {

  constructor(private http: HttpClient) {
    super(http, '/academicRank');
  }
}
