import {CourseProjectTask} from './course-project-task';
import {CourseProjectTopic} from './course-project-topic';

export class CourseProject {

  id: number;
  goal: string;
  countOfHours: number;
  countOfPages: number;
  courseProjectTasks: CourseProjectTask[];
  courseProjectTopics: CourseProjectTopic[];

}
