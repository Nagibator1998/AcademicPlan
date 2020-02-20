import {Topic} from './topic';

export class ActiveTopic {

  id: number;
  activeSpecialityId: number;
  topic: Topic;
  lectureHours: number;
  laboratoryWorkHours: number;
  otherHours: number;
  usrHours: number;
  defense: boolean = true;

}
