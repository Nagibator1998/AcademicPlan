import {Speciality} from './speciality';
import {CourseProject} from './course-project';

export class ActiveSpeciality {

  id: number;
  explanatoryNoteId: number;
  speciality: Speciality;
  course: number;
  semester: number;
  exam: boolean = false;
  courseProject: CourseProject

}
