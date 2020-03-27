import {Component, OnInit} from '@angular/core';
import {Constants} from '../../const/constants';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Router} from '@angular/router';
import {ControlQuestionService} from '../../service/control-question.service';
import {ControlQuestion} from '../../entity/control-question';

@Component({
  selector: 'app-control-question',
  templateUrl: './control-question.component.html',
  styleUrls: ['./control-question.component.css']
})
export class ControlQuestionComponent implements OnInit {

  private explanatoryNote: ExplanatoryNote;
  private controlQuestions: ControlQuestion[] = [];

  constructor(private explanatoryNoteService: ExplanatoryNoteService, private controlQuestionService: ControlQuestionService,
              private router: Router) { }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
  }

  addControlQuestion() {
    let controlQuestion = new ControlQuestion();
    controlQuestion.explanatoryNoteId = this.explanatoryNote.id;
    controlQuestion.questionNumber = this.getMaxWorkNumber() + 1;
    this.controlQuestions.push(controlQuestion);
  }

  deleteControlQuestion(controlQuestion: ControlQuestion) {
    let removeControlQuestion = this.controlQuestions.indexOf(controlQuestion);
    this.controlQuestions.splice(removeControlQuestion, 1);
    for (let i = removeControlQuestion; i < this.controlQuestions.length; i++) {
      this.controlQuestions[i].questionNumber -= 1;
    }

  }

  getMaxWorkNumber(): number {
    let maxWorkNumber = 0;
    for (let controlQuestion of this.controlQuestions) {
      if (controlQuestion.questionNumber > maxWorkNumber) {
        maxWorkNumber = controlQuestion.questionNumber;
      }
    }
    return maxWorkNumber;
  }

  saveControlQuestion() {
    this.controlQuestionService.saveAll(this.controlQuestions).subscribe(data => {
      this.explanatoryNote.controlQuestions = data;
      this.router.navigate([Constants.DIAGNOSTIC_TOOL_PATH]);
    });
  }

}
