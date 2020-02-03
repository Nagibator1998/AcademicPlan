import {Component, OnInit} from '@angular/core';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Constants} from '../../const/constants';
import {StudentMust} from '../../entity/student-must';
import {StudentMustService} from '../../service/student-must.service';

@Component({
  selector: 'app-explanatory-note',
  templateUrl: './explanatory-note.component.html',
  styleUrls: ['./explanatory-note.component.css']
})
export class ExplanatoryNoteComponent implements OnInit {

  private text: string = '';
  private explanatoryNote: ExplanatoryNote;
  private studentMustsKnow: StudentMust[] = [];
  private addedStudentMustsKnow: StudentMust[] = [];
  private changedStudentMustKnow: StudentMust = new StudentMust();
  private studentMustsCan: StudentMust[] = [];
  private addedStudentMustsCan: StudentMust[] = [];
  private changedStudentMustCan: StudentMust = new StudentMust();
  private studentMustsHave: StudentMust[] = [];
  private addedStudentMustsHave: StudentMust[] = [];
  private changedStudentMustHave: StudentMust = new StudentMust();

  constructor(private explanatoryNoteService: ExplanatoryNoteService, private studentMustService: StudentMustService) {
  }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
    this.studentMustService.getAll().subscribe(data => {

      data.forEach(item => {
          switch (item.studentMustType.id) {
            case Constants.STUDENT_MUST_KNOW_TYPE.id:
              this.studentMustsKnow.push(item);
              break;
            case Constants.STUDENT_MUST_CAN_TYPE.id:
              this.studentMustsCan.push(item);
              break;
            case Constants.STUDENT_MUST_HAVE_TYPE.id:
              this.studentMustsHave.push(item);
          }
        }
      );
    });
  }

  setStudentMustKnow(item: StudentMust) {
    this.changedStudentMustKnow = StudentMust.clone(item);
  }

  addStudentMustKnow() {
    let studentMustKnow: StudentMust = StudentMust.clone(this.changedStudentMustKnow);
    studentMustKnow.studentMustType = Constants.STUDENT_MUST_KNOW_TYPE;
    if (studentMustKnow.text != null) {
      this.addedStudentMustsKnow.push(studentMustKnow);
    }
  }

  changeStudentMustKnow(text: string) {
    this.changedStudentMustKnow.text = text;
  }

  clearStudentMustKnow() {
    this.changedStudentMustKnow = new StudentMust();
  }

  deleteStudentMustKnow(studentMustKnow: StudentMust) {
    this.addedStudentMustsKnow.splice(this.addedStudentMustsKnow.indexOf(studentMustKnow), 1);
  }

  setStudentMustCan(item: StudentMust) {
    this.changedStudentMustCan = StudentMust.clone(item);
  }

  addStudentMustCan() {
    let studentMustCan: StudentMust = StudentMust.clone(this.changedStudentMustCan);
    studentMustCan.studentMustType = Constants.STUDENT_MUST_CAN_TYPE;
    if (studentMustCan.text != null) {
      this.addedStudentMustsCan.push(studentMustCan);
    }
  }

  changeStudentMustCan(text: string) {
    this.changedStudentMustCan.text = text;
  }

  clearStudentMustCan() {
    this.changedStudentMustCan = new StudentMust();
  }

  deleteStudentMustCan(studentMustCan: StudentMust) {
    this.addedStudentMustsCan.splice(this.addedStudentMustsCan.indexOf(studentMustCan), 1);
  }

  setStudentMustHave(item: StudentMust) {
    this.changedStudentMustHave = StudentMust.clone(item);
  }

  addStudentMustHave() {
    let studentMustHave: StudentMust = StudentMust.clone(this.changedStudentMustHave);
    studentMustHave.studentMustType = Constants.STUDENT_MUST_HAVE_TYPE;
    if (studentMustHave.text != null) {
      this.addedStudentMustsHave.push(studentMustHave);
    }
  }

  changeStudentMustHave(text: string) {
    this.changedStudentMustHave.text = text;
  }

  clearStudentMustHave() {
    this.changedStudentMustHave = new StudentMust();
  }

  deleteStudentMustHave(studentMustHave: StudentMust) {
    this.addedStudentMustsHave.splice(this.addedStudentMustsHave.indexOf(studentMustHave), 1);
  }

  saveExplanatoryNote() {
    this.explanatoryNote.text = this.text;
    this.explanatoryNote.studentMusts = this.explanatoryNote.studentMusts.concat(this.addedStudentMustsKnow);
    this.explanatoryNote.studentMusts = this.explanatoryNote.studentMusts.concat(this.addedStudentMustsCan);
    this.explanatoryNote.studentMusts = this.explanatoryNote.studentMusts.concat(this.addedStudentMustsHave);
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
    });
  }

}
