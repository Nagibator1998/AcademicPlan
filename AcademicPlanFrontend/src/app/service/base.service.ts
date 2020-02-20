import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export class BaseService<T> {

  private _urlPath: string;

  set urlPath(value: string) {
    this._urlPath = value;
  }

  constructor(private httpClient: HttpClient, urlPath: string) {
    this.urlPath = urlPath;
  }

  public save(entity: T): Observable<T> {
    return this.httpClient.post<T>('/api' + this._urlPath, entity);
  }

  public get(id: number): Observable<T> {
    return this.httpClient.get<T>('/api' + this._urlPath + '/' + id);
  }

  public getAll(): Observable<T[]>{
    return this.httpClient.get<T[]>('/api' + this._urlPath);
  }

  public update(entity: T): Observable<T> {
    return this.httpClient.put<T>('/api' + this._urlPath, entity);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>('/api' + this._urlPath + '/' + id);
  }

  public saveAll(entities: T[]): Observable<T[]>{
    return this.httpClient.post<T[]>('/api' + this._urlPath + '/all', entities);
  }

  public updateAll(entities: T[]): Observable<T[]>{
    return this.httpClient.put<T[]>('/api' + this._urlPath + '/all', entities);
  }

}
