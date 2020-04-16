import {Topic} from './topic';

export class ActiveTopic {

  id: number;
  activeSpecialityId: number;
  topic: Topic;
  lectureHours: number = 0;
  laboratoryWorkHours: number = 0;
  otherHours: number = 0;
  usrHours: number = 0;
  defense: boolean = true;

}
