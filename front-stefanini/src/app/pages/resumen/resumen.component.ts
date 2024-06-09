import { Component, OnInit } from '@angular/core';
import { IPersona } from 'src/app/models/persona-data';
import { IPersonaRequest } from 'src/app/models/persona-request';
import { DataService } from 'src/app/services/data.service';
import { StefaniniApiService } from 'src/app/services/StefaniniApiService';
import { HttpParams } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from 'src/app/components/modal/modal.component';
import { INotFoundPersoneResponse } from 'src/app/models/not-found-person-response';
import { Router } from '@angular/router';

@Component({
  selector: 'app-resumen',
  templateUrl: './resumen.component.html',
  styleUrls: ['./resumen.component.scss']
})
export class ResumenComponent implements OnInit {

  personaData?: IPersona;
  private _personaRequest!: IPersonaRequest;

  constructor(private _stefaniniAPI: StefaniniApiService, private _dataService: DataService, private _modalService: NgbModal, private _router: Router) { }

  ngOnInit(): void {
    this._stefaniniAPI.saludService().subscribe({
      next: (s) => {
        console.info(s)
        this.configurarRequest();
        this.solicitarDatosStefanini();
      },
      error: () => {
        this.consumirDatosQuemados();
      }
    })
  }

  consumirDatosQuemados() {
    this._dataService.obtenerDatosPersonaQuemados().subscribe(response => {
      this.personaData = response;
    })
  }

  solicitarDatosStefanini() {
    let params = new HttpParams()
      .set('tipoDocumento', this._personaRequest.tipoDocumento)
      .set('numeroDocumento', this._personaRequest.numeroDocumento)

    this._stefaniniAPI.obtenerDatosPersona(params).subscribe({
      next: (s) => {
        this.personaData = s;
      },
      error: (e) => {
        this._openModal(e);
      }
    })
  }

  configurarRequest() {
    this._dataService.personaRequest$.subscribe({
      next: (s) => this._personaRequest = s,
      error: (e) => console.error(e)
    });
  }

  private _openModal(e: any) {
    const modRef = this._modalService.open(ModalComponent)
    console.log(e)
    modRef.componentInstance.notFoundPersonResponse = e.error;
    modRef.hidden.subscribe(() => this._router.navigate(['/']))
  }

}
