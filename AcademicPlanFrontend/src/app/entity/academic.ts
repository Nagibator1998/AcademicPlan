import {Position} from './position';
import {AcademicDegree} from './academic-degree';
import {AcademicRank} from './academic-rank';

export class Academic {

  id: number;
  departmentId: number;
  position: Position;
  academicDegree: AcademicDegree;
  academicRank: AcademicRank;
  fullName: string;

}
