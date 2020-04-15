import {Component, OnInit} from '@angular/core';
import {Subject} from '../../entity/subject';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Constants} from '../../const/constants';
import {Router} from '@angular/router';
import {SubjectService} from '../../service/subject.service';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit {

  subject: Subject = new Subject();
  explanatoryNote: ExplanatoryNote = new ExplanatoryNote();
  subjects: Subject[] = [];
  constructor(private explanatoryNoteService: ExplanatoryNoteService, private router: Router, private subjectService: SubjectService) {}


  ngOnInit() {
    this.subjectService.getAll().subscribe(data => {
      this.subjects = data;
    });
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    })
  }

  createSubject(){
    this.explanatoryNote.subject = this.subject;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.router.navigate([Constants.ACTIVE_SPECIALITY_ROUTE_PATH]);
    })
  }

  setSubject(item: Subject){
    this.subject = item;
  }

  clearSubject(){
    this.subject = new Subject();
  }

  changeSubject(name: string){
    this.subject.id = null;
    this.subject.name = name;
  }
}
