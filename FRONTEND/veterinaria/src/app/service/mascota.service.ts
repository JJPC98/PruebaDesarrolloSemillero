import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { api } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MascotaService {

  URL = api.URL;

  constructor(private http: HttpClient) {
  }

  getMostrarMascotas(): Observable<any> {
    return this.http.get<any>(this.URL + '/veterinaria/mascota/lista')
  }

  getGuardarMascota(datos: any): Observable<any> {
    return this.http.post<any>(this.URL + '/veterinaria/mascota/save', datos)
  }

  deleteMascota(id: any): Observable<any> {
    return this.http.delete<any>(this.URL + '/veterinaria/mascota/delete?id=' + id)
  }

  editarMascota(datos: any): Observable<any> {
    return this.http.put<any>(this.URL + '/veterinaria/mascota/update', datos)
  }
}
