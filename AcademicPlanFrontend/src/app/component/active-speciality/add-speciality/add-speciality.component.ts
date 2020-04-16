import {Component, OnInit, ViewChild} from '@angular/core';
import {Department} from '../../../entity/department';
import {Faculty} from '../../../entity/faculty';
import {University} from '../../../entity/university';
import {UniversityService} from '../../../service/university.service';
import {ModalService} from '../../../service/modal.service';
import {ToastrService} from 'ngx-toastr';
import {Speciality} from '../../../entity/speciality';
import {SpecialityService} from '../../../service/speciality.service';

@Component({
  selector: 'app-add-speciality',
  templateUrl: './add-speciality.component.html',
  styleUrls: ['./add-speciality.component.css']
})
export class AddSpecialityComponent implements OnInit {

  speciality: Speciality = new Speciality();
  departments: Department[] = null;
  faculties: Faculty[] = null;
  universities: University[] = [];

  facultyText: string = "";
  departmentText: string = "";

  constructor(private universityService: UniversityService, private specialityService: SpecialityService,
              private modalService: ModalService, private toastrService: ToastrService) {
  }

  ngOnInit() {
    this.universityService.getAll().subscribe(data => {
      this.universities = data;
    });
  }

  addSpeciality(event) {
    this.specialityService.save(this.speciality).subscribe(() => {
      let departmentId = this.speciality.departmentId;
      this.speciality = new Speciality();
      this.speciality.departmentId = departmentId;
      event.target.disabled = false;
      this.toastrService.success('Специальность добавлена успешно');
    }, () => {
      event.target.disabled = false;
      this.toastrService.error('Произошла ошибка');
    });
  }

  closeModal() {
    this.modalService.closeModalWithReloadParentOnInit();
  }

  clearFaculties() {
    this.facultyText = "";
    this.clearDepartments();
    this.faculties = null;
  }

  setFaculties(item: University) {
    this.faculties = item.faculties;
  }

  clearDepartments() {
    this.departmentText = "";
    this.departments = null;
    this.speciality.departmentId = null;
  }

  setDepartments(item: Faculty) {
    this.departments = item.departments;
  }

  removeDepartmentFromSpeciality() {
    this.speciality.departmentId = null;
  }

  setDepartmentToSpeciality(item: Department) {
    this.speciality.departmentId = item.id;
  }

}
