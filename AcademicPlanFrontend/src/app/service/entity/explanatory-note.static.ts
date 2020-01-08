import {Injectable} from '@angular/core';
import {ExplanatoryNote} from '../../entity/explanatory-note';

@Injectable({
  providedIn: 'root'
})

export class ExplanatoryNoteStatic {

  private explanatoryNote: ExplanatoryNote = new ExplanatoryNote();

}
