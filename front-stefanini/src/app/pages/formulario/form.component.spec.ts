import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormComponent } from './form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { IPersonaRequest } from 'src/app/models/persona-request';

describe('FormComponent', () => {
  let component: FormComponent;
  let fixture: ComponentFixture<FormComponent>;
  let mockDataService: jasmine.SpyObj<DataService>;
  let mockRouter: jasmine.SpyObj<Router>;

  beforeEach(async () => {
    const dataSpy = jasmine.createSpyObj('DataService', ['setDatosAConsultar']);
    const routerSpyObj = jasmine.createSpyObj('Router', ['navigate']);
    await TestBed.configureTestingModule({
      declarations: [FormComponent],
      imports: [ReactiveFormsModule],
      providers: [
        { provide: Router, useValue: mockDataService },
        { provide: DataService, useValue: mockRouter }
      ],
      schemas: [NO_ERRORS_SCHEMA]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  })

  it('El componente fue creado', () => {
    expect(component).toBeTruthy();
  });

  it('Inicializacion del formulario', () => {
    const form = component.formularioPersona;
    expect(form.contains('tipoDocumento')).toBeTrue();
    expect(form.contains('numeroDocumento')).toBeTrue();
  })

  it('Formulario con valores', () => {
    const tipoDocumentoControl = component.formularioPersona.get('tipoDocumento');
    const numeroDocumentoControl = component.formularioPersona.get('numeroDocumento');

    expect(tipoDocumentoControl?.valid).toBeFalse;
    expect(numeroDocumentoControl?.valid).toBeFalse;

    tipoDocumentoControl?.setValue('C')
    numeroDocumentoControl?.setValue(1075321508);

    expect(tipoDocumentoControl?.valid).toBeTrue();
    expect(numeroDocumentoControl?.valid).toBeTrue();

  })

  // it('Poder conectarse con el servicio DataService', () => {
  //   component.formularioPersona.setValue({
  //     tipoDocumento: 'P',
  //     numeroDocumento: 1075321508
  //   });

  //   const personaRequest: IPersonaRequest = {
  //     tipoDocumento: 'P',
  //     numeroDocumento: 1075321508
  //   };

  //   // component.onSubmit();
  //   // expect(mockDataService.setDatosAConsultar).toHaveBeenCalledWith(personaRequest);
  //   // expect(mockRouter.navigate).toHaveBeenCalledWith(['persona/', 1075321508]);
  // })
});
