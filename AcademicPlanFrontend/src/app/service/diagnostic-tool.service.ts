import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseService} from './base.service';
import {ExplanatoryNote} from '../entity/explanatory-note';
import {DiagnosticTool} from '../entity/diagnostic-tool';

@Injectable({
  providedIn: 'root'
})

export class DiagnosticToolService extends BaseService<DiagnosticTool>{

  constructor(private http: HttpClient){
    super(http, "/diagnosticTool");
  }
}
