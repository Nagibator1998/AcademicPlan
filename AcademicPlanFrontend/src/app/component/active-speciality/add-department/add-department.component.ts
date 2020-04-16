import {Component, OnInit, ViewChild} from '@angular/core';
import {Faculty} from '../../../entity/faculty';
import {University} from '../../../entity/university';
import {UniversityService} from '../../../service/university.service';
import {FacultyService} from '../../../service/faculty.service';
import {ModalService} from '../../../service/modal.service';
import {ToastrService} from 'ngx-toastr';
import {Department} from '../../../entity/department';
import {DepartmentService} from '../../../service/department.service';

@Component({
  selector: 'app-add-department',
  templateUrl: './add-department.component.html',
  styleUrls: ['./add-department.component.css']
})
export class AddDepartmentComponent implements OnInit {

  department: Department = new Department();
  faculties: Faculty[] = null;
  universities: University[] = [];

  facultyText: string = "";
  constructor(private universityService: UniversityService, private departmentService: DepartmentService,
              private modalService: ModalService, private toastrService: ToastrService) {
  }

  ngOnInit() {
    this.universityService.getAll().subscribe(data => {
      this.universities = data;
    });
  }

  addDepartment(event) {
    this.departmentService.save(this.department).subscribe(() => {
      let facultyId = this.department.facultyId;
      this.department = new Department();
      this.department.facultyId = facultyId;
      event.target.disabled = false;
      this.toastrService.success('Кафедра добавлена успешно');
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
    this.faculties = null;
    this.department.facultyId = null;
  }

  setFaculties(item: University) {
    this.faculties = item.faculties;
  }

  removeFacultyFromDepartment() {
    this.department.facultyId = null;
  }

  setFacultyToDepartment(item: Faculty) {
    this.department.facultyId = item.id;
  }

}
