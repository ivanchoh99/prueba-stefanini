import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPersona } from '../models/persona-data';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StefaniniApiService {

  private _baseUrl: string;

  constructor(private http: HttpClient) {
    this._baseUrl = "http://localhost:8090/api/stefanini"
  }

  obtenerDatosPersona(params: HttpParams): Observable<IPersona> {
    return this.http.get<IPersona>(`${this._baseUrl}/persona`, { params }).pipe(
      catchError(this.handleError)
    );
  }

  saludService(): Observable<string> {
    return this.http.get(`${this._baseUrl}/healt`, { responseType: 'text' })
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error((error.status).toString()));
  }
}
