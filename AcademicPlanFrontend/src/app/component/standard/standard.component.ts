import {Component, OnInit} from '@angular/core';
import {StandardService} from '../../service/standard.service';
import {Standard} from '../../entity/standard';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Constants} from '../../const/constants';
import {ExplanatoryNote} from '../../entity/explanatory-note';

@Component({
  selector: 'app-standard',
  templateUrl: './standard.component.html',
  styleUrls: ['./standard.component.css']
})
export class StandardComponent implements OnInit {

  private standards: Standard[] = [];
  private usedStandards: Standard[] = [];
  private explanatoryNote: ExplanatoryNote;

  constructor(private standardService: StandardService, private explanatoryNoteService: ExplanatoryNoteService) {
  }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    });
    this.standardService.getAll().subscribe(data => {
      this.standards = data;
    });
  }

  setStandard(item: Standard){
    this.usedStandards.push(item);
  }

  deleteStandard(standard: Standard){
    this.usedStandards.splice(this.usedStandards.indexOf(standard), 1);
  }

  saveStandards(){
    this.explanatoryNote.standards = this.usedStandards;
    this.explanatoryNoteService.update(this.explanatoryNote).subscribe(data=>{
      this.explanatoryNote = data;
    })
  }


}
