import {Subject} from './subject';
import {Academic} from './academic';
import {Standard} from './standard';
import {StudentMust} from './student-must';
import {Competence} from './competence';
import {Section} from './section';
import {ActiveSpeciality} from './active-speciality';
import {LaboratoryWork} from './laboratory-work';

export class ExplanatoryNote {

  id: number;
  name: string;
  text: string;
  date: Date;
  subject: Subject;
  reviewers: Academic[];
  creators: Academic[];
  standards: Standard[];
  competences: Competence[];
  studentMusts: StudentMust[];
  sections: Section[];
  activeSpecialities: ActiveSpeciality[];
  laboratoryWorks: LaboratoryWork[];

}
