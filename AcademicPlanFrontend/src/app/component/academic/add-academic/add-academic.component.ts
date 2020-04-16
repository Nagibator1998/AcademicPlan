import { Component, OnInit } from '@angular/core';
import {AcademicDegree} from '../../../entity/academic-degree';
import {AcademicRank} from '../../../entity/academic-rank';
import {Position} from '../../../entity/position';
import {AcademicService} from '../../../service/academic.service';
import {AcademicDegreeService} from '../../../service/academic-degree.service';
import {AcademicRankService} from '../../../service/academic-rank.service';
import {PositionService} from '../../../service/position.service';
import {ModalService} from '../../../service/modal.service';
import {ToastrService} from 'ngx-toastr';
import {Academic} from '../../../entity/academic';
import {Department} from '../../../entity/department';
import {DepartmentService} from '../../../service/department.service';
import {UniversityService} from '../../../service/university.service';
import {University} from '../../../entity/university';
import {Faculty} from '../../../entity/faculty';

@Component({
  selector: 'app-add-academic',
  templateUrl: './add-academic.component.html',
  styleUrls: ['./add-academic.component.css']
})
export class AddAcademicComponent implements OnInit {

  universities: University[] = null;
  faculties: Faculty[] = null;
  departments: Department[] = null;
  academicDegrees: AcademicDegree[] = [];
  academicRanks: AcademicRank[] = [];
  positions: Position[] = [];
  academicDegreesName: string = "";
  academicRanksName: string = "";
  positionsName: string = "";
  firstName: string = "";
  secondName: string = "";
  lastName: string = "";
  facultyText: string = "";
  departmentText: string = "";
  academic: Academic = new Academic();

  constructor(private academicService: AcademicService, private academicDegreeService: AcademicDegreeService,
              private academicRankService: AcademicRankService, private positionService: PositionService,
              private modalService: ModalService, private toastrService: ToastrService,
              private universityService: UniversityService) { }

  ngOnInit(): void {
    this.academicDegreeService.getAll().subscribe(data=>{
      this.academicDegrees = data;
    });
    this.academicRankService.getAll().subscribe(data=>{
      this.academicRanks = data;
    });
    this.positionService.getAll().subscribe(data=>{
      this.positions = data;
    });
    this.universityService.getAll().subscribe(data => {
      this.universities = data;
    });
  }

  setAcademicDegree(item: AcademicDegree){
    this.academic.academicDegree = item;
  }

  setAcademicRank(item: AcademicRank){
    this.academic.academicRank = item;
  }

  setPosition(item: Position){
    this.academic.position = item;
  }

  removeAcademicDegree(){
    this.academic.academicDegree = null;
  }

  removeAcademicRank(){
    this.academic.academicRank = null;
  }

  removePosition(){
    this.academic.position = null;
  }

  setDepartment(item: Department){
    this.academic.departmentId = item.id;
  }

  removeDepartment(){
    this.academic.departmentId = null;
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
    this.departmentText = "";
    this.departments = null;
    this.academic.departmentId = null;
  }

  saveAcademicDegree(event){
    let academicDegree: AcademicDegree = new AcademicDegree();
    academicDegree.name = this.academicDegreesName;
    this.academicDegreeService.save(academicDegree).subscribe(data => {
      this.academicDegrees.push(data);
      this.academicDegreesName = "";
      event.target.disabled = false;
      this.toastrService.success("Ученая степень сохранена");
    }, () => {
      event.target.disabled = false;
      this.toastrService.error("Произошла ошибка");
    });
  }

  saveAcademicRank(event){
    let academicRank: AcademicRank = new AcademicRank();
    academicRank.name = this.academicRanksName;
    this.academicRankService.save(academicRank).subscribe(data => {
      this.academicRanks.push(data);
      this.academicRanksName = "";
      event.target.disabled = false;
      this.toastrService.success("Ученое звание сохранено");
    }, () => {
      event.target.disabled = false;
      this.toastrService.error("Произошла ошибка");
    });
  }

  savePosition(event){
    let position: Position = new Position();
    position.name = this.positionsName;
    this.positionService.save(position).subscribe(data => {
      this.positions.push(data);
      this.positionsName = "";
      event.target.disabled = false;
      this.toastrService.success("Должность сохранена");
    }, () => {
      event.target.disabled = false;
      this.toastrService.error("Произошла ошибка");
    });
  }

  addAcademic(event){
    this.academic.fullName = this.lastName + " " + this.firstName + " " + this.secondName;
    this.academicService.save(this.academic).subscribe(data => {
      this.academic.fullName = "";
      this.firstName = "";
      this.secondName = "";
      this.lastName = "";
      event.target.disabled = false;
      this.toastrService.success("Академик добавлен успешно");
    }, () => {
      event.target.disabled = false;
      this.toastrService.error("Произошла ошибка")
    })
  }

  closeModal(){
    this.modalService.closeModalWithReloadParentOnInit();
  }
}

