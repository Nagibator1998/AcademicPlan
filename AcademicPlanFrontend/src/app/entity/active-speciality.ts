import {Speciality} from './speciality';
import {CourseProject} from './course-project';
import {ActiveTopic} from './active-topic';

export class ActiveSpeciality {

  id: number;
  explanatoryNoteId: number;
  speciality: Speciality;
  semester: number;
  exam: boolean = false;
  courseProject: CourseProject;
  hours: number;
  activeTopics: ActiveTopic[];

}
