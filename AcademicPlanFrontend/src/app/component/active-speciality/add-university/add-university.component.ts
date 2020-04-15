import { Component, OnInit } from '@angular/core';
import {UniversityService} from '../../../service/university.service';
import {University} from '../../../entity/university';
import {ModalService} from '../../../service/modal.service';
import {ToastrModule, ToastrService} from 'ngx-toastr';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-add-university',
  templateUrl: './add-university.component.html',
  styleUrls: ['./add-university.component.css']
})
export class AddUniversityComponent implements OnInit {

  university: University = new University();

  constructor(private universityService: UniversityService, private modalService: ModalService, private toastrService: ToastrService) { }

  ngOnInit() {
  }

  addUniversity(event){
    this.universityService.save(this.university).subscribe(() => {
      this.university = new University();
      event.target.disabled = false;
      this.toastrService.success("Университет добавлен успешно");
    }, error => {
      event.target.disabled = false;
      console.log(event);
      this.toastrService.error("Произошла ошибка");
    });
  }

  closeModal(){
    this.modalService.closeModal();
  }
}
