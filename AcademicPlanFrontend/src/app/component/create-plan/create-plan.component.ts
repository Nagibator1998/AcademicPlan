import {Component, OnInit} from '@angular/core';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Constants} from '../../const/constants';

@Component({
  selector: 'app-create-plan',
  templateUrl: './create-plan.component.html',
  styleUrls: ['./create-plan.component.css']
})
export class CreatePlanComponent implements OnInit {

  explanatoryNote = new ExplanatoryNote();

  constructor(private explanatoryNoteService: ExplanatoryNoteService, private router: Router) {
  }

  ngOnInit() {
  }

  createNote() {
    this.explanatoryNote.date = new Date();
    this.explanatoryNoteService.save(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      localStorage.setItem(Constants.EXPLANATORY_NOTE_ID_STRING, this.explanatoryNote.id.toString());
      this.router.navigate([Constants.SUBJECT_ROUTE_PATH])
    });
  }

}
