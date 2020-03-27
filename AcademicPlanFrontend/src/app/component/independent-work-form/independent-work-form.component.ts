import { Component, OnInit } from '@angular/core';
import {DiagnosticTool} from '../../entity/diagnostic-tool';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {DiagnosticToolService} from '../../service/diagnostic-tool.service';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Router} from '@angular/router';
import {Constants} from '../../const/constants';
import {IndependentWorkForm} from '../../entity/independent-work-form';
import {IndependentWorkFormService} from '../../service/independent-work-form.service';

@Component({
  selector: 'app-independent-work-form',
  templateUrl: './independent-work-form.component.html',
  styleUrls: ['./independent-work-form.component.css']
})
export class IndependentWorkFormComponent implements OnInit {

  private independentWorkForms: IndependentWorkForm[] = [];
  private addedIndependentWorkForms: IndependentWorkForm[] = [];
  private changedIndependentWorkForm: IndependentWorkForm = new IndependentWorkForm();
  private explanatoryNote: ExplanatoryNote;

  constructor(private independentWorkFormService: IndependentWorkFormService, private explanatoryNoteService: ExplanatoryNoteService,
              private router: Router) {
  }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
    this.independentWorkFormService.getAll().subscribe(data => {
      this.independentWorkForms = data;
    });
  }

  setChangedIndependentWorkForm(item: IndependentWorkForm) {
    this.changedIndependentWorkForm = IndependentWorkForm.clone(item);
  }

  addIndependentWorkForm() {
    let independentWorkForm: IndependentWorkForm = IndependentWorkForm.clone(this.changedIndependentWorkForm);
    if (independentWorkForm.text != null) {
      for (let addedIndependentWorkForm of this.addedIndependentWorkForms) {
        if (addedIndependentWorkForm.id != null && independentWorkForm.id != null && addedIndependentWorkForm.id == independentWorkForm.id) {
          return;
        }
      }
      this.addedIndependentWorkForms.push(independentWorkForm);
    }
  }

  deleteIndependentWorkForm(independentWorkForm: IndependentWorkForm) {
    this.addedIndependentWorkForms.splice(this.addedIndependentWorkForms.indexOf(independentWorkForm), 1);
  }

  saveIndependentWorkForms() {
    this.explanatoryNote.independentWorkForms = this.addedIndependentWorkForms;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      this.router.navigate([Constants.INDEPENDENT_WORK_FORM_PATH]);
    });
  }

  changeIndependentWorkForm(text: string) {
    this.changedIndependentWorkForm.id = null;
    this.changedIndependentWorkForm.text = text;
  }

  clearIndependentWorkForm() {
    this.changedIndependentWorkForm = new IndependentWorkForm();
  }

}
