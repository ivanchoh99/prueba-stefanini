import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { INotFoundPersoneResponse } from 'src/app/models/not-found-person-response';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent {

  @Input() notFoundPersonResponse!: INotFoundPersoneResponse

  constructor(public activeModal: NgbActiveModal) {
  }

  close() {
    this.activeModal.dismiss();
  }

}
