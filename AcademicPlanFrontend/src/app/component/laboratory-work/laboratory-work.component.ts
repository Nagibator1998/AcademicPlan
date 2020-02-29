import { Component, OnInit } from '@angular/core';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {LaboratoryWorkService} from '../../service/laboratory-work.service';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {LaboratoryWork} from '../../entity/laboratory-work';
import {Constants} from '../../const/constants';

@Component({
  selector: 'app-laboratory-work',
  templateUrl: './laboratory-work.component.html',
  styleUrls: ['./laboratory-work.component.css']
})
export class LaboratoryWorkComponent implements OnInit {

  private explanatoryNote: ExplanatoryNote;
  private laboratoryWorks: LaboratoryWork[] = [];
  constructor(private explanatoryNoteService: ExplanatoryNoteService, private laboratoryWorkService: LaboratoryWorkService) { }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    })
  }

  addLaboratoryWork(){
    let laboratoryWork = new LaboratoryWork();
    laboratoryWork.explanatoryNoteId = this.explanatoryNote.id;
    laboratoryWork.workNumber = this.getMaxWorkNumber() + 1;
    this.laboratoryWorks.push(laboratoryWork);
  }

  deleteLaboratoryWork(laboratoryWork: LaboratoryWork){
    let removeLaboratoryWorkIndex = this.laboratoryWorks.indexOf(laboratoryWork);
    this.laboratoryWorks.splice(removeLaboratoryWorkIndex, 1);
    for(let i = removeLaboratoryWorkIndex; i < this.laboratoryWorks.length; i++){
      this.laboratoryWorks[i].workNumber -= 1;
    }

  }

  getMaxWorkNumber(): number{
    let maxWorkNumber = 0;
    for(let laboratoryWork of this.laboratoryWorks){
      if(laboratoryWork.workNumber > maxWorkNumber){
        maxWorkNumber = laboratoryWork.workNumber;
      }
    }
    return maxWorkNumber
  }

  saveLaboratoryWorks(){
    this.laboratoryWorkService.saveAll(this.laboratoryWorks).subscribe( data => {
      this.explanatoryNote.laboratoryWorks = data;
    })
  }

}
