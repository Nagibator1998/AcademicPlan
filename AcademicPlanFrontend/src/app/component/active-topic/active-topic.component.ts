import { Component, OnInit } from '@angular/core';
import {ActiveTopic} from '../../entity/active-topic';
import {Section} from '../../entity/section';
import {ExplanatoryNoteService} from '../../service/explanatory-note.service';
import {Constants} from '../../const/constants';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {ActiveSpeciality} from '../../entity/active-speciality';
import {ActiveSpecialityService} from '../../service/active-speciality.service';
import {ActiveTopicService} from '../../service/active-topic.service';

@Component({
  selector: 'app-active-topic',
  templateUrl: './active-topic.component.html',
  styleUrls: ['./active-topic.component.css']
})
export class ActiveTopicComponent implements OnInit {

  private explanatoryNote: ExplanatoryNote;

  constructor(private explanatoryNoteService: ExplanatoryNoteService, private activeSpecialityService: ActiveSpecialityService) { }

  ngOnInit() {
    this.explanatoryNoteService.get(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
      this.explanatoryNote = data;
    })
  }

  setSection(section: Section, activeSpeciality: ActiveSpeciality){
    for(let topic of section.topics){
      let activeTopic = new ActiveTopic();
      activeTopic.activeSpecialityId = activeSpeciality.id;
      activeTopic.topic = topic;
      activeSpeciality.activeTopics.push(activeTopic);
    }
  }

  clearActiveSpeciality(activeSpeciality: ActiveSpeciality){
    activeSpeciality.activeTopics = [];
  }

  deleteActiveTopic(activeSpeciality: ActiveSpeciality, activeTopic: ActiveTopic){
    activeSpeciality.activeTopics.splice(activeSpeciality.activeTopics.indexOf(activeTopic), 1);
  }

  saveActiveTopics(){
    this.activeSpecialityService.updateAll(this.explanatoryNote.activeSpecialities).subscribe(data => {
      this.explanatoryNote.activeSpecialities = data;
      console.log(this.explanatoryNote);
    })

  }

}
