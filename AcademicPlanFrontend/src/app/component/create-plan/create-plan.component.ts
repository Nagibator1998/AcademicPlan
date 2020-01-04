import {Component, OnInit} from '@angular/core';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-create-plan',
  templateUrl: './create-plan.component.html',
  styleUrls: ['./create-plan.component.css']
})
export class CreatePlanComponent implements OnInit {

  explanatoryNote = new ExplanatoryNote();

  constructor(private service: ExplanatoryNoteService, private router: Router) {
  }

  ngOnInit() {
  }

  createNote() {
    this.explanatoryNote.date = new Date();
    this.service.save(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
    });
  }

}
