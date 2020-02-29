import {Component, OnInit} from '@angular/core';
import {CourseProjectService} from '../../service/course-project.service';
import {ExplanatoryNote} from '../../entity/explanatory-note';
import {CourseProject} from '../../entity/course-project';
import {Constants} from '../../const/constants';
import {CourseProjectTask} from '../../entity/course-project-task';
import {CourseProjectTaskService} from '../../service/course-project-task.service';
import {CourseProjectTopic} from '../../entity/course-project-topic';

@Component({
  selector: 'app-course-project',
  templateUrl: './course-project.component.html',
  styleUrls: ['./course-project.component.css']
})
export class CourseProjectComponent implements OnInit {

  private courseProject: CourseProject;
  private courseProjectTasks: CourseProjectTask[] = [];
  private changedCourseProjectTask: CourseProjectTask;

  constructor(private courseProjectService: CourseProjectService, private courseProjectTaskService: CourseProjectTaskService) {
  }

  ngOnInit() {
    this.courseProjectService.getByExplanatoryNoteId(parseInt(localStorage.getItem(Constants.EXPLANATORY_NOTE_ID_STRING))).subscribe(data => {
        this.courseProject = data;
      });
    this.courseProjectTaskService.getAll().subscribe(data => {
      this.courseProjectTasks = data;
    });
  }

  setCourseProjectTask(courseProjectTask: CourseProjectTask) {
    this.changedCourseProjectTask = CourseProjectTask.clone(courseProjectTask);
  }

  addCourseProjectTask() {
    let courseProjectTask = CourseProjectTask.clone(this.changedCourseProjectTask);
    if (courseProjectTask.text != null) {
      for (let addedCourseProjectTask of this.courseProject.courseProjectTasks) {
        if (addedCourseProjectTask.id != null && courseProjectTask.id != null && courseProjectTask.id == addedCourseProjectTask.id) {
          return;
        }
      }
      this.courseProject.courseProjectTasks.push(courseProjectTask);
    }
  }

  changeCourseProjectTask(text: string) {
    this.changedCourseProjectTask.id = null;
    this.changedCourseProjectTask.text = text;
  }

  clearCourseProjectTask() {
    this.changedCourseProjectTask = new CourseProjectTask();
  }

  deleteCourseProjectTask(courseProjectTask: CourseProjectTask) {
    this.courseProject.courseProjectTasks.splice(this.courseProject.courseProjectTasks.indexOf(courseProjectTask), 1);
  }

  addCourseProjectTopic() {
    let courseProjectTopic = new CourseProjectTopic();
    courseProjectTopic.topicNumber = this.getMaxTopicNumber() + 1;
    courseProjectTopic.courseProjectId = this.courseProject.id;
    this.courseProject.courseProjectTopics.push(courseProjectTopic);
  }

  deleteCourseProjectTopic(courseProjectTopic: CourseProjectTopic) {
    let removeCourseProjectTopicIndex = this.courseProject.courseProjectTopics.indexOf(courseProjectTopic);
    this.courseProject.courseProjectTopics.splice(this.courseProject.courseProjectTopics.indexOf(courseProjectTopic), 1);
    for(let i = removeCourseProjectTopicIndex; i < this.courseProject.courseProjectTopics.length; i++){
      this.courseProject.courseProjectTopics[i].topicNumber -= 1;
    }
  }

  getMaxTopicNumber(): number {
    let maxTopicNumber = 0;
    for (let courseProjectTopic of this.courseProject.courseProjectTopics) {
      if (courseProjectTopic.topicNumber > maxTopicNumber) {
        maxTopicNumber = courseProjectTopic.topicNumber;
      }
    }
    return maxTopicNumber;
  }

  saveCourseProject(){
    console.log(this.courseProject);
    this.courseProjectService.update(this.courseProject).subscribe(data => {
      this.courseProject = data;
    })
  }
}
