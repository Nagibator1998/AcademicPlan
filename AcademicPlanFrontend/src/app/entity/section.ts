import {Topic} from './topic';

export class Section {
  id: number;
  name: string;
  sectionNumber: number;
  explanatoryNoteId: number;
  topics: Topic[];
}
