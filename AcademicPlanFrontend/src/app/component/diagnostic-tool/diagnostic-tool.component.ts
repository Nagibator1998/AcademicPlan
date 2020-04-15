import { Component, OnInit } from '@angular/core';
import {Standard} from '../../entity/standard';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {StandardService} from '../../service/standard.service';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Router} from '@angular/router';
import {Constants} from '../../const/constants';
import {DiagnosticTool} from '../../entity/diagnostic-tool';
import {DiagnosticToolService} from '../../service/diagnostic-tool.service';

@Component({
  selector: 'app-diagnostic-tool',
  templateUrl: './diagnostic-tool.component.html',
  styleUrls: ['./diagnostic-tool.component.css']
})
export class DiagnosticToolComponent implements OnInit {

  diagnosticTools: DiagnosticTool[] = [];
  addedDiagnosticTools: DiagnosticTool[] = [];
  changedDiagnosticTool: DiagnosticTool = new DiagnosticTool();
  explanatoryNote: ExplanatoryNote;

  constructor(private diagnosticToolService: DiagnosticToolService, private explanatoryNoteService: ExplanatoryNoteService,
              private router: Router) {
  }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
    this.diagnosticToolService.getAll().subscribe(data => {
      this.diagnosticTools = data;
    });
  }

  setChangedDiagnosticTool(item: DiagnosticTool) {
    this.changedDiagnosticTool = DiagnosticTool.clone(item);
  }

  addDiagnosticTool() {
    let diagnosticTool: DiagnosticTool = DiagnosticTool.clone(this.changedDiagnosticTool);
    if (diagnosticTool.text != null) {
      for (let addedDiagnosticTool of this.addedDiagnosticTools) {
        if (addedDiagnosticTool.id != null && diagnosticTool.id != null && addedDiagnosticTool.id == diagnosticTool.id) {
          return;
        }
      }
      this.addedDiagnosticTools.push(diagnosticTool);
    }
  }

  deleteDiagnosticTool(diagnosticTool: DiagnosticTool) {
    this.addedDiagnosticTools.splice(this.addedDiagnosticTools.indexOf(diagnosticTool), 1);
  }

  saveDiagnosticTools() {
    this.explanatoryNote.diagnosticTools = this.addedDiagnosticTools;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      this.router.navigate([Constants.INDEPENDENT_WORK_FORM_PATH]);
    });
  }

  changeDiagnosticTool(text: string) {
    this.changedDiagnosticTool.id = null;
    this.changedDiagnosticTool.text = text;
  }

  clearDiagnosticTool() {
    this.changedDiagnosticTool = new DiagnosticTool();
  }

}
