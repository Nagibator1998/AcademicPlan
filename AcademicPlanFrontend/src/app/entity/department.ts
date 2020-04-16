import {Speciality} from './speciality';

export class Department {

  id: number;
  name: string;
  abbreviation: string;
  specialities: Speciality[];
  facultyId: number;

}
