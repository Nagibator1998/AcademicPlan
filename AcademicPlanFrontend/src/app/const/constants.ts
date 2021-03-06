import {StudentMustType} from '../entity/student-must-type';

export class Constants {

  public static EXPLANATORY_NOTE_ID_STRING = 'explanatoryNoteId';
  public static CREATE_PLAN_ROUTE_PATH = 'create-plan';
  public static SUBJECT_ROUTE_PATH = 'subject';
  public static JUMBOTRON_ROUTE_PATH = 'jumbotron';
  public static ACTIVE_SPECIALITY_ROUTE_PATH = 'activeSpeciality';
  public static ACADEMIC_ROUTE_PATH = 'academic';
  public static STANDARD_ROUTE_PATH = 'standard';
  public static EXPLANATORY_NOTE_ROUTE_PATH = 'explanatoryNote';
  public static COMPETENCE_ROUTE_PATH = 'competence';
  public static SECTION_ROUTE_PATH = 'section';
  public static ACTIVE_TOPIC_PATH = 'activeTopic';
  public static LABORATORY_WORK_PATH = 'laboratoryWork';
  public static COURSE_PROJECT_PATH = 'courseProject';
  public static CONTROL_QUESTION_PATH = 'controlQuestion';
  public static DIAGNOSTIC_TOOL_PATH = 'diagnosticTool';
  public static INDEPENDENT_WORK_FORM_PATH = 'independentWorkForm';
  public static LITERATURE_PATH = 'literature';

  public static STUDENT_MUST_KNOW_TYPE: StudentMustType = {'id': 1, 'type': 'KNOW'};
  public static STUDENT_MUST_CAN_TYPE: StudentMustType = {'id': 2, 'type': 'CAN'};
  public static STUDENT_MUST_HAVE_TYPE: StudentMustType = {'id': 3, 'type': 'HAVE'};
}
