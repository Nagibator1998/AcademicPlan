export class CourseProjectTask {
  id: number;
  text: string;

  static clone(courseProjectTask: CourseProjectTask): CourseProjectTask {
    let clonedCloseProjectTask: CourseProjectTask = new CourseProjectTask();
    clonedCloseProjectTask.id = courseProjectTask.id;
    clonedCloseProjectTask.text = courseProjectTask.text;
    return clonedCloseProjectTask;
  }
}
