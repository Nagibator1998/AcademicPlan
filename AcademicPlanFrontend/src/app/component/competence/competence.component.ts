import {Component, OnInit} from '@angular/core';
import {Competence} from '../../entity/competence';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {CompetenceService} from '../../service/competence.service';
import {Constants} from '../../const/constants';
import {Router} from '@angular/router';

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.css']
})
export class CompetenceComponent implements OnInit {

  private competences: Competence[] = [];
  private explanatoryNote: ExplanatoryNote;
  private addedCompetences: Competence[] = [];

  constructor(private explanatoryNoteService: ExplanatoryNoteService, private competenceService: CompetenceService,
              private router: Router) {
  }

  ngOnInit() {
    this.competenceService.getCompetencesForThisExplanatoryNote(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING)))
      .subscribe(data => {
        this.competences = data;
      });
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
  }

  addCompetence(item: Competence) {
    this.addedCompetences.push(item);
    this.competences.splice(this.competences.indexOf(item), 1);
  }

  deleteCompetence(competence: Competence) {
    this.addedCompetences.splice(this.addedCompetences.indexOf(competence), 1);
    this.competences.push(competence);
  }

  saveCompetences() {
    this.explanatoryNote.competences = this.addedCompetences;
    console.log(this.explanatoryNote.competences);
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      this.router.navigate([Constants.SECTION_ROUTE_PATH]);
    });
  }

}
