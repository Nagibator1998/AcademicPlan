import {CompetenceCode} from './competence-code';
import {Speciality} from './speciality';

export class Competence {
  id: number;
  text: string;
  competenceCode: CompetenceCode;
  speciality: Speciality;
}
