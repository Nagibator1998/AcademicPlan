import {Component, OnInit} from '@angular/core';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Router} from '@angular/router';
import {Constants} from '../../const/constants';
import {LiteratureService} from '../../service/literature.service';
import {Literature} from '../../entity/literature';

@Component({
  selector: 'app-literature',
  templateUrl: './literature.component.html',
  styleUrls: ['./literature.component.css']
})
export class LiteratureComponent implements OnInit {

  private literature: Literature[] = [];
  private basicLiterature: Literature[] = [];
  private additionalLiterature: Literature[] = [];
  private explanatoryNote: ExplanatoryNote;

  constructor(private literatureService: LiteratureService, private explanatoryNoteService: ExplanatoryNoteService,
              private router: Router) {
  }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
    this.literatureService.getAll().subscribe(data => {
      this.literature = data;
    });
  }

  setBasicLiterature(item: Literature) {
    this.basicLiterature.push(item);
    this.literature.splice(this.literature.indexOf(item), 1);
  }

  deleteFromBasicLiterature(basicLiterature: Literature) {
    this.basicLiterature.splice(this.basicLiterature.indexOf(basicLiterature), 1);
    this.literature.push(basicLiterature);
  }

  setAdditionalLiterature(item: Literature) {
    this.additionalLiterature.push(item);
    this.literature.splice(this.literature.indexOf(item), 1);
  }

  deleteFromAdditionalLiterature(additionalLiterature: Literature) {
    this.additionalLiterature.splice(this.additionalLiterature.indexOf(additionalLiterature), 1);
    this.literature.push(additionalLiterature);
  }

  saveLiterature() {
    this.explanatoryNote.basicLiterature = this.basicLiterature;
    this.explanatoryNote.additionalLiterature = this.additionalLiterature;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      //this.router.navigate([Constants.EXPLANATORY_NOTE_ROUTE_PATH]);
    });
  }


}
