import {Component, OnInit} from '@angular/core';
import {AcademicService} from '../../service/academic.service';
import {Academic} from '../../entity/academic';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {Constants} from '../../const/constants';

@Component({
  selector: 'app-academic',
  templateUrl: './academic.component.html',
  styleUrls: ['./academic.component.css']
})
export class AcademicComponent implements OnInit {

  private academics: Academic[] = [];
  private reviewers: Academic[] = [];
  private creators: Academic[] = [];
  private explanatoryNote: ExplanatoryNote;

  constructor(private academicService: AcademicService, private explanatoryNoteService: ExplanatoryNoteService) {
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
    for (let reviewer of this.reviewers) {
      if (reviewer.id == item.id) {
        return;
      }
    }
    this.reviewers.push(item);
  }

  deleteFromReviewers(reviewer: Academic) {
    this.reviewers.splice(this.reviewers.indexOf(reviewer), 1);
  }

  setCreator(item: Academic) {
    for (let creator of this.creators) {
      if (creator.id == item.id) {
        return;
      }
    }
    this.creators.push(item);
  }

  deleteFromCreators(creator: Academic) {
    this.creators.splice(this.creators.indexOf(creator), 1);
  }

  saveCreatorsAndReviewers(){
    this.explanatoryNote.reviewers = this.reviewers;
    this.explanatoryNote.creators = this.creators;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
    })
  }
}
