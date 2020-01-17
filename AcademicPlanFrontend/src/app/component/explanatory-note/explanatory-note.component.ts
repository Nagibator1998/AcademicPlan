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

  private explanatoryNote: ExplanatoryNote;
  private studentMusts: StudentMust[] = [];
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
      this.studentMusts = data;
    });
  }

  setStudentMustKnow(item: StudentMust) {
    this.changedStudentMustKnow = StudentMust.clone(item);
  }

  addStudentMustKnow(){
    let studentMustKnow: StudentMust = StudentMust.clone(this.changedStudentMustKnow);
    studentMustKnow.studentMustType = Constants.STUDENT_MUST_KNOW_TYPE;
    if(studentMustKnow.text != null){
      this.addedStudentMustsKnow.push(studentMustKnow);
    }
  }

  changeStudentMustKnow(text: string){
    this.changedStudentMustKnow.text = text;
  }

  clearStudentMustKnow(){
    this.changedStudentMustKnow = new StudentMust();
  }

  deleteStudentMustKnow(studentMustKnow: StudentMust){
    this.addedStudentMustsKnow.splice(this.addedStudentMustsKnow.indexOf(studentMustKnow), 1);
  }

  saveExplanatoryNote() {
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
    });
  }

}
