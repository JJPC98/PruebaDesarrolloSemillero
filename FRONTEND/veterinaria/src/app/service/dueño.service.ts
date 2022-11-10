import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { api } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DueñoService {

  URL = api.URL;

  constructor(private http: HttpClient) {
  }

  getMostrarDueños(): Observable<any> {
    return this.http.get<any>(this.URL + '/veterinaria/dueño/lista')
  }

  getGuardarDueño(datos: any): Observable<any> {
    return this.http.post<any>(this.URL + '/veterinaria/dueño/save', datos)
  }

  deleteDueño(id: any): Observable<any> {
    return this.http.delete<any>(this.URL + '/veterinaria/dueño/delete?id=' + id)
  }

  editarDueño(datos: any): Observable<any> {
    return this.http.put<any>(this.URL + '/veterinaria/dueño/update', datos)
  }
}

