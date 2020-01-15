import {Component, OnInit, ViewChild} from '@angular/core';
import {UniversityService} from '../../service/university.service';
import {University} from '../../entity/university';
import {Faculty} from '../../entity/faculty';
import {Department} from '../../entity/department';
import {Speciality} from '../../entity/speciality';
import {ActiveSpeciality} from '../../entity/active-speciality';
import {Constants} from '../../const/constants';
import {CourseProject} from '../../entity/course-project';
import {ActiveSpecialityService} from '../../service/active-speciality.service';
import {CourseProjectService} from '../../service/course-project.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-department',
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
  @ViewChild('ngFaculties', {static: false}) facultiesForm;
  @ViewChild('ngDepartments', {static: false}) departmentsForm;
  @ViewChild('ngSpecialities', {static: false}) specialitiesForm;

  constructor(private universityService: UniversityService, private activeSpecialityService: ActiveSpecialityService,
              private router: Router) {
  }

  ngOnInit() {
    this.universityService.getAll().subscribe(data => {
      this.universities = data;
    });
  }

  setFaculties(item: University) {
    this.faculties = item.faculties == undefined ? null : item.faculties;
  }

  clearFaculties() {
    this.clearDepartments();
    this.facultiesForm.clear();
    this.faculties = null;
  }

  setDepartments(item: Faculty) {
    this.departments = item.departments == undefined ? null : item.departments;
  }

  clearDepartments() {
    this.clearSpecialities();
    this.departmentsForm.clear();
    this.departments = null;
  }

  setSpecialities(item: Department) {
    this.specialities = item.specialities == undefined ? null : item.specialities;
    this.activeSpecialities = [];
  }

  clearSpecialities() {
    this.specialitiesForm.clear();
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

}
