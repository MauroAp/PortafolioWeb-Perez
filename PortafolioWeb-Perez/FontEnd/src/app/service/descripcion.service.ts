import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Descripcion } from '../model/descripcion';

@Injectable({
  providedIn: 'root'
})
export class DescripcionService {
  URL = 'http://localhost:8080/descripcion/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Descripcion[]> {
    return this.httpClient.get<Descripcion[]>(this.URL + 'lista');
  }

  public details(id: number): Observable<Descripcion> {
    return this.httpClient.get<Descripcion>(this.URL + `details/${id}`)
  }

  public save(descripcion: Descripcion): Observable<any> {
    return this.httpClient.post<any>(this.URL + 'create', descripcion);
  }

  public update(id: number, descripcion: Descripcion): Observable<any> {
    return this.httpClient.put<any>(this.URL + `update/${id}`, descripcion);
  }
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.URL + `delete/${id}`);
  }

}
