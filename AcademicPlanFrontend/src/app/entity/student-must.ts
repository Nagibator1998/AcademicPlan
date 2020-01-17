import {StudentMustType} from './student-must-type';

export class StudentMust {
  id: number;
  text: string;
  studentMustType: StudentMustType;

  public static clone(studentMust: StudentMust): StudentMust {
    let cloneStudentMust: StudentMust = new StudentMust();
    cloneStudentMust.id = studentMust.id;
    cloneStudentMust.text = studentMust.text;
    cloneStudentMust.studentMustType = studentMust.studentMustType;
    return cloneStudentMust;
  }
}
