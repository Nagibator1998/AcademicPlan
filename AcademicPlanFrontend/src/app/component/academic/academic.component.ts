import {Component, OnInit} from '@angular/core';
import {AcademicService} from '../../service/academic.service';
import {Academic} from '../../entity/academic';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {Constants} from '../../const/constants';
import {Router} from '@angular/router';

@Component({
  selector: 'app-academic',
  templateUrl: './academic.component.html',
  styleUrls: ['./academic.component.css']
})
export class AcademicComponent implements OnInit {

  academics: Academic[] = [];
  reviewers: Academic[] = [];
  creators: Academic[] = [];
  explanatoryNote: ExplanatoryNote;

  constructor(private academicService: AcademicService, private explanatoryNoteService: ExplanatoryNoteService,
              private router: Router) {
  }

  ngOnInit() {
    this.academicService.getAll().subscribe(data => {
      this.academics = data;
    });
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
  }

  setReviewer(item: Academic) {
    this.reviewers.push(item);
    this.academics.splice(this.academics.indexOf(item), 1);
  }

  deleteFromReviewers(reviewer: Academic) {
    this.reviewers.splice(this.reviewers.indexOf(reviewer), 1);
    this.academics.push(reviewer);
  }

  setCreator(item: Academic) {
    this.creators.push(item);
    this.academics.splice(this.academics.indexOf(item), 1);
  }

  deleteFromCreators(creator: Academic) {
    this.creators.splice(this.creators.indexOf(creator), 1);
    this.academics.push(creator);
  }

  saveCreatorsAndReviewers() {
    this.explanatoryNote.reviewers = this.reviewers;
    this.explanatoryNote.creators = this.creators;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      this.router.navigate([Constants.STANDARD_ROUTE_PATH]);
    });
  }
}
