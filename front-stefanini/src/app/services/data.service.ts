import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { IPersona } from '../models/persona-data';
import { IPersonaRequest } from '../models/persona-request';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  private _personaRequest = new BehaviorSubject<IPersonaRequest>({ tipoDocumento: '', numeroDocumento: '' })
  personaRequest$ = this._personaRequest.asObservable();

  constructor(private http: HttpClient) { }

  obtenerDatosPersonaQuemados(): Observable<IPersona> {
    return this.http.get<IPersona>('assets/datos.json')
  }

  setDatosAConsultar(personaRequest: IPersonaRequest) {
    personaRequest.numeroDocumento = personaRequest.numeroDocumento.replace(/\./g, '')
    this._personaRequest.next(personaRequest);
  }

}
