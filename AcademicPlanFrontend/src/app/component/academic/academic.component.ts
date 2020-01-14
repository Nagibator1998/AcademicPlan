import { Component, OnInit } from '@angular/core';
import {AcademicService} from '../../service/academic.service';
import {Academic} from '../../entity/academic';

@Component({
  selector: 'app-academic',
  templateUrl: './academic.component.html',
  styleUrls: ['./academic.component.css']
})
export class AcademicComponent implements OnInit {

  private academics: Academic[] = [];
  private reviewers: Academic[] = [];
  private creators: Academic[] = [];
  constructor(private academicService: AcademicService) { }

  ngOnInit() {
  }

  setReviewer(item: Academic){
    for(let reviewer of this.reviewers){
      if(reviewer.id == item.id){
        return;
      }
    }
    this.reviewers.push(item);
  }

}
