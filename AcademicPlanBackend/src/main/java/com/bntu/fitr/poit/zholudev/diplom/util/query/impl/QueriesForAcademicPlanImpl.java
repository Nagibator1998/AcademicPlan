package com.bntu.fitr.poit.zholudev.diplom.util.query.impl;

import com.bntu.fitr.poit.zholudev.diplom.entity.*;
import com.bntu.fitr.poit.zholudev.diplom.util.query.QueriesForAcademicPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueriesForAcademicPlanImpl implements QueriesForAcademicPlan {

    private static final String GET_UNIVERSITY_BY_EXPLANATORY_NOTE_QUERY =
            "select un.* from universities un, faculties fac, departments dep, specialities spec where " +
                    "spec.id = ? " +
                    "and spec.department_id = dep.id " +
                    "and dep.faculty_id = fac.id " +
                    "and fac.university_id = un.id";

    private static final String GET_UNIVERSITY_BY_DEPARTMENT_QUERY =
            "select un.* from universities un, faculties fac where " +
                    "fac.id = ? and fac.university_id = un.id";

    private static final String GET_DEPARTMENT_BY_ACADEMIC_QUERY =
            "select * from departments where departments.id = ?";

    private static final String GET_STUDENT_MUSTS_BY_STUDENT_MUST_TYPE_AND_EXPLANATORY_NOTE =
            "select sm.* from student_musts sm, explanatory_notes_student_musts ensm where " +
                    "ensm.explanatory_note_id = ? " +
                    "and ensm.student_musts_id = sm.id " +
                    "and sm.student_must_type_id = ?";

    private static final String GET_SPECIALITIES_FOR_EXPLANATORY_NOTE =
            "select distinct spec.* from specialities spec, active_specialities acs where " +
                    "acs.explanatory_note_id = ? " +
                    "and acs.speciality_id = spec.id";

    private static final String GET_COMPETENCES_BY_SPECIALITY_AND_EXPLANATORY_NOTE =
            "select comp.* from competences comp, explanatory_notes_competences expnc where " +
                    "expnc.explanatory_note_id = ? " +
                    "and expnc.competences_id = comp.id " +
                    "and comp.speciality_id = ?";

    private static final String GET_COMPETENCE_CODE_BY_ID =
            "select * from competence_codes where competence_codes.id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public University getUniversityByExplanatoryNote(ExplanatoryNote explanatoryNote) {
        Long specialityId = explanatoryNote.getActiveSpecialities().get(0).getSpeciality().getId();
        return jdbcTemplate.query(GET_UNIVERSITY_BY_EXPLANATORY_NOTE_QUERY, new Object[]{specialityId}, get_university);
    }

    @Override
    public Department getDepartmentByAcademic(Academic academic) {
        Long departmentId = academic.getDepartmentId();
        return jdbcTemplate.query(GET_DEPARTMENT_BY_ACADEMIC_QUERY, new Object[]{departmentId}, new ResultSetExtractor<Department>() {
            @Override
            public Department extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                resultSet.next();
                Department department = new Department();
                department.setId(resultSet.getLong("id"));
                department.setName(resultSet.getString("name"));
                department.setAbbreviation(resultSet.getString("abbreviation"));
                department.setFacultyId(resultSet.getLong("faculty_id"));
                return department;
            }
        });
    }

    @Override
    public University getUniversityByDepartment(Department department) {
        Long facultyId = department.getFacultyId();
        return jdbcTemplate.query(GET_UNIVERSITY_BY_DEPARTMENT_QUERY, new Object[]{facultyId}, get_university);
    }

    @Override
    public List<StudentMust> getStudentMustsBuStudentMustTypeAndExplanatoryNote(StudentMustType studentMustType, ExplanatoryNote explanatoryNote) {
        return jdbcTemplate.query(GET_STUDENT_MUSTS_BY_STUDENT_MUST_TYPE_AND_EXPLANATORY_NOTE,
                new Object[]{explanatoryNote.getId(), studentMustType.getId()}, resultSet -> {
                    List<StudentMust> studentMusts = new ArrayList<>();
                    while (resultSet.next()) {
                        StudentMust studentMust = new StudentMust();
                        studentMust.setId(resultSet.getLong("id"));
                        studentMust.setText(resultSet.getString("text"));
                        studentMust.setStudentMustType(studentMustType);
                        studentMusts.add(studentMust);
                    }
                    return studentMusts;
                });
    }

    @Override
    public List<Speciality> getSpecialitiesForExplanatoryNote(ExplanatoryNote explanatoryNote) {
        return jdbcTemplate.query(GET_SPECIALITIES_FOR_EXPLANATORY_NOTE, new Object[]{explanatoryNote.getId()}, resultSet -> {
            List<Speciality> specialities = new ArrayList<>();
            while (resultSet.next()) {
                Speciality speciality = new Speciality();
                speciality.setId(resultSet.getLong("id"));
                speciality.setName(resultSet.getString("name"));
                speciality.setAbbreviation(resultSet.getString("abbreviation"));
                speciality.setCode(resultSet.getString("code"));
                speciality.setDepartmentId(resultSet.getLong("department_id"));
                speciality.setDirection(resultSet.getBoolean("direction"));
                speciality.setFullTime(resultSet.getBoolean("full_time"));
                specialities.add(speciality);
            }
            return specialities;
        });
    }

    @Override
    public List<Competence> getCompetencesBySpecialityAndExplanatoryNote(Speciality speciality, ExplanatoryNote explanatoryNote) {
        return jdbcTemplate.query(GET_COMPETENCES_BY_SPECIALITY_AND_EXPLANATORY_NOTE,
                new Object[]{explanatoryNote.getId(), speciality.getId()}, resultSet -> {
                    List<Competence> competences = new ArrayList<>();
                    while (resultSet.next()) {
                        Competence competence = new Competence();
                        competence.setId(resultSet.getLong("id"));
                        competence.setText(resultSet.getString("text"));
                        competence.setCompetenceCode(getCompetenceCodeById(resultSet.getLong("competence_code_id")));
                        competences.add(competence);
                    }
                    return competences;
                });
    }

    private CompetenceCode getCompetenceCodeById(Long id) {
        return jdbcTemplate.query(GET_COMPETENCE_CODE_BY_ID, new Object[]{id}, resultSet -> {
            resultSet.next();
            CompetenceCode competenceCode = new CompetenceCode();
            competenceCode.setId(resultSet.getLong("id"));
            competenceCode.setCode(resultSet.getString("code"));
            return competenceCode;
        });
    }

    private ResultSetExtractor<University> get_university = new ResultSetExtractor<University>() {
        @Override
        public University extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            resultSet.next();
            University university = new University();
            university.setId(resultSet.getLong("id"));
            university.setName(resultSet.getString("name"));
            university.setAbbreviation(resultSet.getString("abbreviation"));
            return university;
        }
    };
}
