package com.bntu.fitr.poit.zholudev.diplom.util.query;

import com.bntu.fitr.poit.zholudev.diplom.entity.*;

import java.util.List;

public interface QueriesForAcademicPlan {
    University getUniversityByExplanatoryNote(ExplanatoryNote explanatoryNote);
    Department getDepartmentByAcademic(Academic academic);
    University getUniversityByDepartment(Department department);
    List<StudentMust> getStudentMustsBuStudentMustTypeAndExplanatoryNote(StudentMustType studentMustType,
                                                                         ExplanatoryNote explanatoryNote);
    List<Speciality> getSpecialitiesForExplanatoryNote(ExplanatoryNote explanatoryNote);
    List<Competence> getCompetencesBySpecialityAndExplanatoryNote(Speciality speciality, ExplanatoryNote explanatoryNote);
}
