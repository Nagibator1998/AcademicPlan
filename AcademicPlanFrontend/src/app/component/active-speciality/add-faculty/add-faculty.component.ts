import {Component, OnInit, ViewChild} from '@angular/core';
import {University} from '../../../entity/university';
import {UniversityService} from '../../../service/university.service';
import {ModalService} from '../../../service/modal.service';
import {ToastrService} from 'ngx-toastr';
import {Faculty} from '../../../entity/faculty';
import {FacultyService} from '../../../service/faculty.service';

@Component({
  selector: 'app-add-faculty',
  templateUrl: './add-faculty.component.html',
  styleUrls: ['./add-faculty.component.css']
})
export class AddFacultyComponent implements OnInit {

  faculty: Faculty = new Faculty();
  universities: University[] = [];

  constructor(private universityService: UniversityService, private facultyService: FacultyService,
              private modalService: ModalService, private toastrService: ToastrService) { }

  ngOnInit() {
    this.universityService.getAll().subscribe(data => {
      this.universities = data;
    })
  }

  addFaculty(event){
    this.facultyService.save(this.faculty).subscribe(() => {
      let universityId = this.faculty.universityId;
      this.faculty = new Faculty();
      this.faculty.universityId = universityId;
      event.target.disabled = false;
      this.toastrService.success("Факультет добавлен успешно");
    }, () => {
      event.target.disabled = false;
      console.log(event);
      this.toastrService.error("Произошла ошибка");
    })
  }

  closeModal(){
    this.modalService.closeModal();
  }

  removeUniversityFromFaculty(){
    this.faculty.universityId = null;
  }

  setUniversityToFaculty(item: University){
    this.faculty.universityId = item.id;
  }

}
