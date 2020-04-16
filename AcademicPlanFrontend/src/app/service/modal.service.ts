import {Injectable, OnInit, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  public modalRef: BsModalRef;
  private component: OnInit;

  constructor(private modalService: BsModalService) {
  }

  public openModal(template: TemplateRef<any>, component: OnInit): void {
    this.modalRef = this.modalService.show(template, {backdrop: 'static'});
    this.component = component;
  }

  public closeModalWithReloadParentOnInit(){
    this.component.ngOnInit();
    this.modalRef.hide()
    this.component = null;
  }

  public closeModal() {
    this.modalRef.hide()
  }


}
