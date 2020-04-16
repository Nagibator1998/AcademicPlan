import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {UniversityService} from '../../service/university.service';
import {University} from '../../entity/university';
import {Faculty} from '../../entity/faculty';
import {Department} from '../../entity/department';
import {Speciality} from '../../entity/speciality';
import {ActiveSpeciality} from '../../entity/active-speciality';
import {Constants} from '../../const/constants';
import {CourseProject} from '../../entity/course-project';
import {ActiveSpecialityService} from '../../service/active-speciality.service';
import {Router} from '@angular/router';
import {ModalService} from '../../service/modal.service';

@Component({
  selector: 'app-active-speciality',
  templateUrl: './active-speciality.component.html',
  styleUrls: ['./active-speciality.component.css']
})
export class ActiveSpecialityComponent implements OnInit {

  universities: University[] = null;
  faculties: Faculty[] = null;
  departments: Department[] = null;
  specialities: Speciality[] = null;
  activeSpecialities: ActiveSpeciality[] = null;
  courseProject: CourseProject = new CourseProject();

  facultyText: string = "";
  departmentText: string = "";
  specialityText: string = "";

  constructor(private universityService: UniversityService, private activeSpecialityService: ActiveSpecialityService,
              private router: Router, private modalService: ModalService) {
  }

  ngOnInit() {
    this.universityService.getAll().subscribe(data => {
      this.universities = data;
    });
  }

  setFaculties(item: University) {
    this.faculties = item.faculties;
  }

  clearFaculties() {
    this.clearDepartments();
    this.facultyText = "";
    this.faculties = null;
  }

  setDepartments(item: Faculty) {
    this.departments = item.departments;
  }

  clearDepartments() {
    this.clearSpecialities();
    this.departmentText = "";
    this.departments = null;
  }

  setSpecialities(item: Department) {
    this.specialities = item.specialities;
    this.activeSpecialities = [];
  }

  clearSpecialities() {
    this.specialityText = "";
    this.specialities = null;
  }

  setActiveSpecialities(item: Speciality) {
    let addActiveSpeciality = new ActiveSpeciality();
    addActiveSpeciality.speciality = item;
    addActiveSpeciality.explanatoryNoteId = parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING));
    this.activeSpecialities.push(addActiveSpeciality);
  }

  deleteActiveSpeciality(activeSpeciality: ActiveSpeciality) {
    this.activeSpecialities.splice(this.activeSpecialities.indexOf(activeSpeciality), 1);
  }

  setCourseProject(item, activeSpeciality: ActiveSpeciality) {
    if (item.target.checked) {
      activeSpeciality.courseProject = this.courseProject;
    } else {
      activeSpeciality.courseProject = null;
    }
  }

  saveActiveSpecialities() {
    this.activeSpecialityService.saveAll(this.activeSpecialities).subscribe(data => {
      this.activeSpecialities = data;
      this.router.navigate([Constants.ACADEMIC_ROUTE_PATH]);
    });
  }

  openModal(template: TemplateRef<any>) {
    this.modalService.openModal(template, this);
  }

}
