import {Component, OnInit} from '@angular/core';
import {StandardService} from '../../service/standard.service';
import {Standard} from '../../entity/standard';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Constants} from '../../const/constants';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {Router} from '@angular/router';

@Component({
  selector: 'app-standard',
  templateUrl: './standard.component.html',
  styleUrls: ['./standard.component.css']
})
export class StandardComponent implements OnInit {

  standards: Standard[] = [];
  addedStandards: Standard[] = [];
  changedStandard: Standard = new Standard();
  explanatoryNote: ExplanatoryNote;

  constructor(private standardService: StandardService, private explanatoryNoteService: ExplanatoryNoteService,
              private router: Router) {
  }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
    this.standardService.getAll().subscribe(data => {
      this.standards = data;
    });
  }

  setChangedStandard(item: Standard) {
    this.changedStandard = Standard.clone(item);
  }

  addStandard() {
    let standard: Standard = Standard.clone(this.changedStandard);
    if (standard.name != null) {
      for (let addedStandard of this.addedStandards) {
        if (addedStandard.id != null && standard.id != null && addedStandard.id == standard.id) {
          return;
        }
      }
      this.addedStandards.push(standard);
    }
  }

  deleteStandard(standard: Standard) {
    this.addedStandards.splice(this.addedStandards.indexOf(standard), 1);
  }

  saveStandards() {
    this.explanatoryNote.standards = this.addedStandards;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data => {
      this.explanatoryNote = data;
      this.router.navigate([Constants.EXPLANATORY_NOTE_ROUTE_PATH]);
    });
  }

  changeStandard(name: string) {
    this.changedStandard.id = null;
    this.changedStandard.name = name;
  }

  clearStandard() {
    this.changedStandard = new Standard();
  }

}
