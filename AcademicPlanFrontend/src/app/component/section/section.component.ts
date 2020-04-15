import {Component, OnInit} from '@angular/core';
import {SectionService} from '../../service/section.service';
import {Router} from '@angular/router';
import {Section} from '../../entity/section';
import {Topic} from '../../entity/topic';
import {Constants} from '../../const/constants';

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnInit {

  sections: Section[] = [];
  sectionName: string = '';

  constructor(private sectionService: SectionService, private router: Router) {
  }

  ngOnInit() {
  }

  addSection() {
    let section = new Section();
    section.name = this.sectionName;
    section.sectionNumber = this.getMaxNumberOfSections() + 1;
    section.topics = [];
    section.explanatoryNoteId = parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING));
    this.sections.push(section);
  }

  addTopic(section: Section) {
    let topic = new Topic();
    topic.topicNumber = this.getMaxNumberOfTopics(section) + 1;
    topic.sectionId = section.id;
    section.topics.push(topic);
  }

  deleteSection(section: Section) {
    let removedSectionIndex = this.sections.indexOf(section);
    this.sections.splice(removedSectionIndex, 1);
    for (let i = removedSectionIndex; i < this.sections.length; i++) {
      this.sections[i].sectionNumber -= 1;
    }

  }

  deleteTopic(section: Section, topic: Topic) {
    let removedTopicIndex = section.topics.indexOf(topic);
    section.topics.splice(removedTopicIndex, 1);
    for (let i = removedTopicIndex; i < section.topics.length; i++) {
      section.topics[i].topicNumber -= 1;
    }
  }

  private getMaxNumberOfSections(): number {
    let max = 0;
    for (let section of this.sections) {
      if (section.sectionNumber > max) {
        max = section.sectionNumber;
      }
    }
    return max;
  }

  private getMaxNumberOfTopics(section: Section): number {
    let max = 0;
    for (let topic of section.topics) {
      if (topic.topicNumber > max) {
        max = topic.topicNumber;
      }
    }
    return max;
  }

  saveSections() {
    this.sectionService.saveAll(this.sections).subscribe(data => {
      this.sections = data;
      this.router.navigate([Constants.ACTIVE_TOPIC_PATH]);
    });
  }

}
