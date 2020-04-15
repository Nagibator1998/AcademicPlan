import { Component, OnInit } from '@angular/core';
import {UniversityService} from '../../../service/university.service';
import {University} from '../../../entity/university';
import {ModalService} from '../../../service/modal.service';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.css']
})
export class AddUniversityComponent implements OnInit {

  private university: University = new University();

  constructor(private universityService: UniversityService, private modalService: ModalService) { }

  ngOnInit() {
  }

  addUniversity(event){
    this.universityService.save(this.university).subscribe(() => {
      this.university = new University();
      event.target.disable = false;
    }, () => {
      event.target.disable = false;
    })
  }

  closeModal(){
    this.modalService.closeModal();
  }
}
