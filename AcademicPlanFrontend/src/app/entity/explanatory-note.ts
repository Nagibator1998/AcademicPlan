import {Subject} from './subject';
import {Academic} from './academic';
import {Standard} from './standard';

export class ExplanatoryNote {

  id: number;
  name: string;
  text: string;
  date: Date;
  subject: Subject;
  reviewers: Academic[];
  creators: Academic[];
  standards: Standard[];

}
