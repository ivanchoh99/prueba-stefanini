import { Component } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { IPersonaRequest } from "src/app/models/persona-request";
import { DataService } from "src/app/services/data.service";


@Component({
    selector: 'app-form',
    templateUrl: './form.component.html',
    styleUrls: ['./form.component.scss']
})
export class FormComponent {

    formularioPersona: FormGroup;

    formatiarNumero(event: Event) {
        let inputElement = event.target as HTMLInputElement;
        let nuevoValor = inputElement.value.replace(/\D/g, '');
        nuevoValor = nuevoValor.replace(/\B(?=(\d{3})+(?!\d))/g, '.');
        this.formularioPersona.get('numeroDocumento')?.setValue(nuevoValor);
    }

    onSubmit() {
        const personaRequest: IPersonaRequest = {
            tipoDocumento: this.formularioPersona.get('tipoDocumento')?.value,
            numeroDocumento: this.formularioPersona.get('numeroDocumento')?.value
        }
        this._dataService.setDatosAConsultar(personaRequest)
        this._router.navigate(['persona/', personaRequest.numeroDocumento.replace('.', '')])
    }

    constructor(private formBuilder: FormBuilder, private _router: Router, private _dataService: DataService) {
        this.formularioPersona = this.formBuilder.group({
            tipoDocumento: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(1)]],
            numeroDocumento: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(14)]]
        });
    }
}