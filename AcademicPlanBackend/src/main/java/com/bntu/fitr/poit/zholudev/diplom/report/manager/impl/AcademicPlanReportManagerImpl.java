package com.bntu.fitr.poit.zholudev.diplom.report.manager.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.*;
import com.bntu.fitr.poit.zholudev.diplom.report.manager.ReportManager;
import com.bntu.fitr.poit.zholudev.diplom.util.query.QueriesForAcademicPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("academicPlanReportManager")
public class AcademicPlanReportManagerImpl implements ReportManager {

    private static final String EMPTY_STRING = "";

    private ExplanatoryNote explanatoryNote;

    @Autowired
    private QueriesForAcademicPlan queriesForReport;

    @Override
    public void setExplanatoryNote(ExplanatoryNote explanatoryNote) {
        this.explanatoryNote = explanatoryNote;
    }

    public String getUniversityNameByExplanatoryNote() {
        University university = queriesForReport.getUniversityByExplanatoryNote(explanatoryNote);
        return university != null ? university.getName() : EMPTY_STRING;
    }

    public String getSubjectName() {
        Subject subject = explanatoryNote.getSubject();
        return subject != null ? subject.getName() : EMPTY_STRING;
    }

    public String getSpecialitiesForTitle() {
        List<ActiveSpeciality> activeSpecialities = explanatoryNote.getActiveSpecialities();
        if (CollectionUtils.isEmpty(activeSpecialities)) {
            return EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder();
        for (ActiveSpeciality activeSpeciality : activeSpecialities) {
            Speciality speciality = activeSpeciality.getSpeciality();
            if (speciality == null) {
                continue;
            }
            builder.append(speciality.getCode()).append(" ").append(speciality.getName()).append("\n");
        }
        return builder.toString();
    }

    public String getDate() {
        Date date = explanatoryNote.getDate();
        if (date == null) {
            return EMPTY_STRING;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return EMPTY_STRING + calendar.get(Calendar.YEAR);
    }

    public String getStandards() {
        List<Standard> standards = explanatoryNote.getStandards();
        if (CollectionUtils.isEmpty(standards)) {
            return EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder();
        for (Standard standard : standards) {
            builder.append("- ").append(standard.getName()).append(";\n");
        }
        return builder.toString();
    }

    public String getCreators() {
        List<Academic> creators = explanatoryNote.getCreators();
        if (CollectionUtils.isEmpty(creators)) {
            return EMPTY_STRING;
        }
        return getAcademics(creators);
    }

    public String getReviewers() {
        List<Academic> reviewers = explanatoryNote.getReviewers();
        if (CollectionUtils.isEmpty(reviewers)) {
            return EMPTY_STRING;
        }
        return getAcademics(reviewers);
    }

    public String getExplanatoryNoteText() {
        return explanatoryNote.getText();
    }

    public String getStudentMustKnows() {
        return getStudentMustsByType(EntityConstants.STUDENT_MUST_KNOW_TYPE);
    }

    public String getStudentMustCans() {
        return getStudentMustsByType(EntityConstants.STUDENT_MUST_CAN_TYPE);
    }

    public String getStudentMustMusts() {
        return getStudentMustsByType(EntityConstants.STUDENT_MUST_HAVE_TYPE);
    }

    public String getCompetences() {
        List<Competence> competences = explanatoryNote.getCompetences();
        if (CollectionUtils.isEmpty(competences)) {
            return EMPTY_STRING;
        }
        StringBuilder builder = new StringBuilder();
        for (Competence competence : competences) {
            if (competence.getSpeciality() == null) {
                builder.append(competence.getCompetenceCode().getCode()).
                        append(". ").
                        append(competence.getText()).
                        append(".\n");
            }
        }
        return builder.append(getCompetencesForSpecialities()).toString();
    }

    private String getCompetencesForSpecialities() {
        StringBuilder builder = new StringBuilder();
        List<Speciality> specialities = queriesForReport.getSpecialitiesForExplanatoryNote(explanatoryNote);
        for (Speciality speciality : specialities) {
            List<Competence> competences = queriesForReport.
                    getCompetencesBySpecialityAndExplanatoryNote(speciality, explanatoryNote);
            if(CollectionUtils.isEmpty(competences)){
                continue;
            }
            builder.append("    для специальности ").
                    append(speciality.getCode()).
                    append(" \"").
                    append(speciality.getName()).
                    append("\":\n");
            for (Competence competence : competences) {
                builder.append(competence.getCompetenceCode().getCode()).
                        append(". ").
                        append(competence.getText()).
                        append(".\n");
            }
        }
        return builder.toString();
    }


    private String getStudentMustsByType(StudentMustType studentMustType) {
        List<StudentMust> studentMustKnows = queriesForReport.
                getStudentMustsBuStudentMustTypeAndExplanatoryNote(studentMustType, explanatoryNote);
        StringBuilder builder = new StringBuilder();
        for (StudentMust studentMust : studentMustKnows) {
            builder.append("- ").
                    append(studentMust.getText()).
                    append(";\n");
        }
        return builder.toString();
    }

    private String getAcademics(List<Academic> academics) {
        StringBuilder builder = new StringBuilder();
        for (Academic creator : academics) {
            builder.append(creator.getFullName()).
                    append(", ");
            Department department = queriesForReport.getDepartmentByAcademic(creator);
            University university = queriesForReport.getUniversityByDepartment(department);
            builder.append(creator.getPosition().getName()).
                    append(" \"").
                    append(department.getName()).
                    append("\" Учреждения образования \"").
                    append(university.getName()).
                    append("\", ").
                    append(creator.getAcademicDegree().getName()).
                    append(", ").
                    append(creator.getAcademicRank().getName()).
                    append(".\n\n");
        }
        return builder.toString();
    }

    @Override
    public String getFileName() {
        return explanatoryNote.getName();
    }


}
