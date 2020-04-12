package com.bntu.fitr.poit.zholudev.diplom.report.manager.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.*;
import com.bntu.fitr.poit.zholudev.diplom.report.manager.ReportManager;
import com.bntu.fitr.poit.zholudev.diplom.util.query.QueriesForAcademicPlan;
import com.bntu.fitr.poit.zholudev.diplom.util.sort.Sort;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigInteger;
import java.util.*;

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

    public void getUniversityNameByExplanatoryNote(XmlCursor cursor, XWPFDocument document) {
        University university = queriesForReport.getUniversityByExplanatoryNote(explanatoryNote);
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        setBold16TimesNewRomanRun(run);
        run.setText(university.getName());
    }

    public void getSubjectName(XmlCursor cursor, XWPFDocument document) {
        Subject subject = explanatoryNote.getSubject();
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        setBold14TimesNewRomanRun(run);
        run.setText(subject.getName());
    }

    public void getSpecialitiesForTitle(XmlCursor cursor, XWPFDocument document) {
        List<Speciality> specialities = queriesForReport.getFullTimeSpecialitiesForExplanatoryNote(explanatoryNote);
        if (CollectionUtils.isEmpty(specialities)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        setBold14TimesNewRomanRun(run);
        for (Speciality speciality : specialities) {
            run.addCarriageReturn();
            run.setText(speciality.getCode() + " " + speciality.getName());
        }
    }

    public void getDate(XmlCursor cursor, XWPFDocument document) {
        Date date = explanatoryNote.getDate();
        if (date == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        run.setText(calendar.get(Calendar.YEAR) + " г.");
    }

    public void getStandards(XmlCursor cursor, XWPFDocument document) {
        List<Standard> standards = explanatoryNote.getStandards();
        if (CollectionUtils.isEmpty(standards)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (Standard standard : standards) {
            run.addCarriageReturn();
            run.setText("- " + standard.getName());
        }
    }

    public void getCreators(XmlCursor cursor, XWPFDocument document) {
        List<Academic> creators = explanatoryNote.getCreators();
        if (CollectionUtils.isEmpty(creators)) {
            return;
        }
        getAcademics(creators, cursor, document);
    }

    public void getReviewers(XmlCursor cursor, XWPFDocument document) {
        List<Academic> reviewers = explanatoryNote.getReviewers();
        if (CollectionUtils.isEmpty(reviewers)) {
            return;
        }
        getAcademics(reviewers, cursor, document);
    }

    public void getExplanatoryNoteText(XmlCursor cursor, XWPFDocument document) {
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        String[] splitText = explanatoryNote.getText().split("\n");
        for (String text : splitText) {
            run.addTab();
            run.setText(text);
            run.addCarriageReturn();
        }
    }

    public void getStudentMustKnows(XmlCursor cursor, XWPFDocument document) {
        getStudentMustsByType(EntityConstants.STUDENT_MUST_KNOW_TYPE, cursor, document);
    }

    public void getStudentMustCans(XmlCursor cursor, XWPFDocument document) {
        getStudentMustsByType(EntityConstants.STUDENT_MUST_CAN_TYPE, cursor, document);
    }

    public void getStudentMustHaves(XmlCursor cursor, XWPFDocument document) {
        getStudentMustsByType(EntityConstants.STUDENT_MUST_HAVE_TYPE, cursor, document);
    }

    public void getCompetences(XmlCursor cursor, XWPFDocument document) {
        List<Competence> competences = explanatoryNote.getCompetences();
        if (CollectionUtils.isEmpty(competences)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (Competence competence : competences) {
            if (competence.getSpeciality() == null) {
                run.setText(competence.getCompetenceCode().getCode() + ". " + competence.getText() + ".");
                run.addCarriageReturn();
            }
        }
        removeLastCarriageReturn(run);
        getCompetencesForSpecialities(run);
    }

    public void getSummaryOfHours(XmlCursor cursor, XWPFDocument document) {
        List<Speciality> specialities = queriesForReport.getSpecialitiesForExplanatoryNote(explanatoryNote);
        if (CollectionUtils.isEmpty(specialities)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (Speciality speciality : specialities) {
            StringBuilder builder = new StringBuilder();
            int allHours = 0;
            int auditHours = 0;
            CourseProject courseProject = null;
            for (ActiveSpeciality activeSpeciality : getActiveSpecialitiesForSpeciality(speciality)) {
                allHours += activeSpeciality.getHours();
                CourseProject courseProjectForSpeciality = activeSpeciality.getCourseProject();
                if (courseProjectForSpeciality != null) {
                    courseProject = courseProjectForSpeciality;
                }
                auditHours += getSummaryOfLectureHours(activeSpeciality) + getSummaryOfLaboratoryWorkHours(activeSpeciality);
            }
            builder.append("- для ").
                    append(speciality.getFullTime() ? "очной " : "заочной ").
                    append("формы получения высшего образования по специальности ").
                    append(speciality.getCode()).
                    append(" всего ").
                    append(allHours).
                    append(" ч., из них аудиторных - ").
                    append(auditHours).append(" ч.").
                    append(courseProject != null ? " (на курсовую работу отведено всего " +
                            courseProject.getCountOfHours() + " ч. самостоятельной работы);" : ";");
            run.addTab();
            run.setText(builder.toString());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    public void getSummaryOfHoursTable(XmlCursor cursor, XWPFDocument document) throws Exception {
        List<Speciality> fullTimeSpecialities = queriesForReport.getFullTimeSpecialitiesForExplanatoryNote(explanatoryNote);
        if (CollectionUtils.isEmpty(fullTimeSpecialities)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = paragraph.createRun();
        set12TimesNewRomanRun(run);
        run.setText("Таблица 1");
        XWPFTable table = document.insertNewTbl(getNewCursor(document, paragraph));
        fillSummaryOfHoursTableBySpecialities(fullTimeSpecialities, table, "Очная форма получения высшего образования");
        List<Speciality> partTimeSpecialities = queriesForReport.getPartTimeSpecialitiesForExplanatoryNote(explanatoryNote);
        if (CollectionUtils.isEmpty(partTimeSpecialities)) {
            return;
        }
        paragraph = document.insertNewParagraph(getNewCursor(document, table));
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        run = paragraph.createRun();
        set12TimesNewRomanRun(run);
        run.setText("Таблица 2");
        table = document.insertNewTbl(getNewCursor(document, paragraph));
        fillSummaryOfHoursTableBySpecialities(partTimeSpecialities, table, "Заочная форма получения высшего образования");
    }

    public void getSections(XmlCursor cursor, XWPFDocument document) throws Exception {
        List<Section> sections = explanatoryNote.getSections();
        Sort.sortListByFieldAscending(sections, "sectionNumber");
        for (Section section : sections) {
            XWPFParagraph paragraph = document.insertNewParagraph(cursor);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            setBold14TimesNewRomanRun(run);
            run.addCarriageReturn();
            run.setText("РАЗДЕЛ " + section.getSectionNumber() + ". " + section.getName().toUpperCase());
            List<Topic> topics = section.getTopics();
            Sort.sortListByFieldAscending(topics, "topicNumber");
            cursor = getNewCursor(document, paragraph);
            for (Topic topic : topics) {
                XWPFParagraph topicNameParagraph = document.insertNewParagraph(cursor);
                topicNameParagraph.setAlignment(ParagraphAlignment.CENTER);
                XWPFRun topicNameRun = topicNameParagraph.createRun();
                setBold14TimesNewRomanRun(topicNameRun);
                topicNameRun.addCarriageReturn();
                topicNameRun.setText("Тема " + section.getSectionNumber() + "." +
                        topic.getTopicNumber() + ". " + topic.getName());
                cursor = getNewCursor(document, topicNameParagraph);

                XWPFParagraph topicTextParagraph = document.insertNewParagraph(cursor);
                topicTextParagraph.setAlignment(ParagraphAlignment.BOTH);
                XWPFRun topicTextRun = topicTextParagraph.createRun();
                set14TimesNewRomanRun(topicTextRun);
                topicTextRun.addCarriageReturn();
                topicTextRun.addTab();
                topicTextRun.setText(topic.getText());
                cursor = getNewCursor(document, topicTextParagraph);
            }
        }
    }

    public void getCourseProject(XmlCursor cursor, XWPFDocument document) {
        List<ActiveSpeciality> activeSpecialities = explanatoryNote.getActiveSpecialities();
        if (CollectionUtils.isEmpty(activeSpecialities)) {
            return;
        }
        CourseProject courseProject = getCourseProject();
        if (courseProject == null) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        setBold14TimesNewRomanRun(run);
        run.setText("ТРЕБОВАНИЯ К КУРСОВОЙ РАБОТЕ");
        cursor = getNewCursor(document, paragraph);
        XWPFParagraph courseProjectParagraph = document.insertNewParagraph(cursor);
        courseProjectParagraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun courseProjectRun = courseProjectParagraph.createRun();
        set14TimesNewRomanRun(courseProjectRun);
        courseProjectRun.addTab();
        courseProjectRun.setText("Цель курсовой работы - " + courseProject.getGoal());
        courseProjectRun.addCarriageReturn();
        courseProjectRun.addTab();
        courseProjectRun.setText("Задачами курсовой работы являются:");
        for (CourseProjectTask courseProjectTask : courseProject.getCourseProjectTasks()) {
            courseProjectRun.addCarriageReturn();
            courseProjectRun.addTab();
            courseProjectRun.setText("- " + courseProjectTask.getText() + ";");
        }
        courseProjectRun.addCarriageReturn();
        courseProjectRun.addTab();
        courseProjectRun.setText("Примерный объем пояснительной записки " + courseProject.getCountOfPages() + " страниц");
        courseProjectRun.addCarriageReturn();
        courseProjectRun.addTab();
        courseProjectRun.setText("Количество часов на выполнение курсовой работы - " +
                courseProject.getCountOfHours() + " ч. самостоятельно работы.");

    }

    public void getActiveTopicsTable(XmlCursor cursor, XWPFDocument document) throws Exception {
        List<Speciality> fullTimeSpecialities = queriesForReport.getFullTimeSpecialitiesForExplanatoryNote(explanatoryNote);
        if (CollectionUtils.isEmpty(fullTimeSpecialities)) {
            return;
        }
        cursor = getActiveTopicsTable(fullTimeSpecialities, cursor, document);
        List<Speciality> partTimeSpecialities = queriesForReport.getPartTimeSpecialitiesForExplanatoryNote(explanatoryNote);
        if (CollectionUtils.isEmpty(partTimeSpecialities)) {
            return;
        }
        getActiveTopicsTable(partTimeSpecialities, cursor, document);

    }

    public void getDiagnosticTools(XmlCursor cursor, XWPFDocument document) {
        List<DiagnosticTool> diagnosticTools = explanatoryNote.getDiagnosticTools();
        if (CollectionUtils.isEmpty(diagnosticTools)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (DiagnosticTool diagnosticTool : diagnosticTools) {
            run.addTab();
            run.setText("- " + diagnosticTool.getText());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    public void getLaboratoryWorks(XmlCursor cursor, XWPFDocument document) throws Exception {
        List<LaboratoryWork> laboratoryWorks = explanatoryNote.getLaboratoryWorks();
        if (CollectionUtils.isEmpty(laboratoryWorks)) {
            return;
        }
        Sort.sortListByFieldAscending(laboratoryWorks, "workNumber");
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (LaboratoryWork laboratoryWork : laboratoryWorks) {
            run.setText(laboratoryWork.getWorkNumber() + ".");
            run.addTab();
            run.setText(laboratoryWork.getText());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    public void getCourseProjectTopics(XmlCursor cursor, XWPFDocument document) throws Exception {
        CourseProject courseProject = getCourseProject();
        if (courseProject == null) {
            return;
        }
        List<CourseProjectTopic> courseProjectTopics = courseProject.getCourseProjectTopics();
        if (CollectionUtils.isEmpty(courseProjectTopics)) {
            return;
        }
        Sort.sortListByFieldAscending(courseProjectTopics, "topicNumber");
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (CourseProjectTopic courseProjectTopic : courseProjectTopics) {
            run.setText(courseProjectTopic.getTopicNumber() + ".");
            run.addTab();
            run.setText(courseProjectTopic.getText());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    public void getControlQuestions(XmlCursor cursor, XWPFDocument document) throws Exception {
        List<ControlQuestion> controlQuestions = explanatoryNote.getControlQuestions();
        if (CollectionUtils.isEmpty(controlQuestions)) {
            return;
        }
        Sort.sortListByFieldAscending(controlQuestions, "questionNumber");
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (ControlQuestion controlQuestion : controlQuestions) {
            run.setText(controlQuestion.getQuestionNumber() + ".");
            run.addTab();
            run.setText(controlQuestion.getText());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    public void getIndependentWorkForms(XmlCursor cursor, XWPFDocument document) {
        List<IndependentWorkForm> independentWorkForms = explanatoryNote.getIndependentWorkForms();
        if (CollectionUtils.isEmpty(independentWorkForms)) {
            return;
        }
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (IndependentWorkForm independentWorkForm : independentWorkForms) {
            run.addTab();
            run.setText("- " + independentWorkForm.getText());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    private XmlCursor getNewCursor(XWPFDocument document, IBodyElement bodyElement) {
        List<IBodyElement> bodyElements = document.getBodyElements();
        IBodyElement nextElement = bodyElements.get(bodyElements.indexOf(bodyElement) + 1);
        if ("PARAGRAPH".equals(nextElement.getElementType().name())) {
            return ((XWPFParagraph) nextElement).getCTP().newCursor();
        }
        return ((XWPFTable) nextElement).getCTTbl().newCursor();
    }

    private XmlCursor getActiveTopicsTable(List<Speciality> specialities, XmlCursor cursor, XWPFDocument document) throws Exception{
        for (Speciality speciality : specialities) {
            XWPFParagraph paragraph = document.insertNewParagraph(cursor);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            setBold14TimesNewRomanRun(run);
            run.setText("УЧЕБНО-МЕТОДИЧЕСКАЯ КАРТА УЧЕБНОЙ ДИСЦИПЛИНЫ");
            run.addCarriageReturn();
            run.setText("очная форма колучения высшего образования, специальность " + speciality.getCode());
            XWPFTable table = document.insertNewTbl(getNewCursor(document, paragraph));
            XWPFTableRow headerRow = table.getRow(0);
            setTextToCenterInVerticalDirectionInCell(headerRow.getCell(0), "Номер раздела, темы");
            setTextToHCenterVCenterInCell(headerRow.createCell(), "Название раздела, темы");
            setTextToHCenterVCenterInCell(headerRow.createCell(), "Количество аудиторных часов");
            createEmptyCells(headerRow, 2);
            setTextToCenterInVerticalDirectionInCell(headerRow.createCell(), "Количество часов УСР");
            setTextToCenterInVerticalDirectionInCell(headerRow.createCell(), "Форма контроля знаний");
            CTHMerge hMerge = CTHMerge.Factory.newInstance();
            hMerge.setVal(STMerge.RESTART);
            headerRow.getCell(2).getCTTc().getTcPr().setHMerge(hMerge);
            hMerge.setVal(STMerge.CONTINUE);
            headerRow.getCell(3).getCTTc().addNewTcPr().setHMerge(hMerge);
            headerRow.getCell(4).getCTTc().addNewTcPr().setHMerge(hMerge);
            headerRow = table.createRow();
            headerRow.setHeight(2400);
            setTextToCenterInVerticalDirectionInCell(headerRow.getCell(2), "Лекции");
            setTextToCenterInVerticalDirectionInCell(headerRow.getCell(3), "Лабораторные занятия");
            setTextToCenterInVerticalDirectionInCell(headerRow.getCell(4), "Иное");
            CTVMerge vMerge = CTVMerge.Factory.newInstance();
            vMerge.setVal(STMerge.RESTART);
            table.getRow(0).getCell(0).getCTTc().getTcPr().setVMerge(vMerge);
            table.getRow(0).getCell(1).getCTTc().getTcPr().setVMerge(vMerge);
            table.getRow(0).getCell(5).getCTTc().getTcPr().setVMerge(vMerge);
            table.getRow(0).getCell(6).getCTTc().getTcPr().setVMerge(vMerge);
            vMerge.setVal(STMerge.CONTINUE);
            headerRow.getCell(0).getCTTc().addNewTcPr().setVMerge(vMerge);
            headerRow.getCell(1).getCTTc().addNewTcPr().setVMerge(vMerge);
            headerRow.getCell(5).getCTTc().addNewTcPr().setVMerge(vMerge);
            headerRow.getCell(6).getCTTc().addNewTcPr().setVMerge(vMerge);
            headerRow = table.createRow();
            setTextToHCenterVCenterInCell(headerRow.getCell(0), "1");
            for (int i = 1; i < 7; i++) {
                setTextToHCenterVCenterInCell(headerRow.getCell(i), String.valueOf(i + 1));
            }
            List<ActiveSpeciality> activeSpecialities = getActiveSpecialitiesForSpeciality(speciality);
            Sort.sortListByFieldAscending(activeSpecialities, "semester");
            for (ActiveSpeciality activeSpeciality : activeSpecialities) {
                XWPFTableRow row = table.createRow();
                XWPFTableCell cell = row.getCell(0);
                setBoldTextToHCenterVTopInCell(row.getCell(1), activeSpeciality.getSemester() + " семестр");
                List<ActiveTopic> activeTopics = activeSpeciality.getActiveTopics();
                Sort.sortListByFieldAscending(activeTopics, "topic.topicNumber");
                Section section = queriesForReport.getSectionForTopic(activeTopics.get(0).getTopic());
                row = table.createRow();
                setTextToHCenterVTopInCell(row.getCell(0), section.getSectionNumber().toString());
                setTextToHLeftVTopInCell(row.getCell(1), section.getName().toUpperCase());
                for(ActiveTopic activeTopic: activeTopics){
                    row = table.createRow();
                    setTextToHLeftVTopInCell(row.getCell(0), section.getSectionNumber() + "." +
                            activeTopic.getTopic().getTopicNumber());
                    setTextToHLeftVTopInCell(row.getCell(1), activeTopic.getTopic().getName());
                    setTextToHCenterVTopInCell(row.getCell(2), getHoursInString(activeTopic.getLectureHours()));
                    setTextToHCenterVTopInCell(row.getCell(3), getHoursInString(activeTopic.getLaboratoryWorkHours()));
                    setTextToHCenterVTopInCell(row.getCell(4), getHoursInString(activeTopic.getOtherHours()));
                    setTextToHCenterVTopInCell(row.getCell(5), getHoursInString(activeTopic.getUsrHours()));
                    setTextToHLeftVTopInCell(row.getCell(6), activeTopic.getDefense() ? "Защита лабораторной работы" : EMPTY_STRING);
                    CourseProject courseProject = activeSpeciality.getCourseProject();
                    if(courseProject != null){
                        row = table.createRow();
                        setTextToHLeftVTopInCell(row.getCell(1), "Курсовая работа");
                        setTextToHLeftVTopInCell(row.getCell(6), "Защита курсовой работы");
                    }
                }
                row = table.createRow();
                setBoldTextToHRightrVTopInCell(row.getCell(1), "Итого за семестр");
                setBoldTextToHCenterVTopInCell(row.getCell(2), getHoursInString(getSummaryOfLectureHours(activeSpeciality)));
                setBoldTextToHCenterVTopInCell(row.getCell(3), getHoursInString(getSummaryOfLaboratoryWorkHours(activeSpeciality)));
                setBoldTextToHCenterVTopInCell(row.getCell(4), getHoursInString(getSummaryOfOtherHours(activeSpeciality)));
                setBoldTextToHCenterVTopInCell(row.getCell(5), getHoursInString(getSummaryOfUsrHours(activeSpeciality)));
            }
            XWPFTableRow row = table.createRow();
            setBoldTextToHRightrVTopInCell(row.getCell(1), "Всего аудиторных часов");
            hMerge.setVal(STMerge.RESTART);
            row.getCell(2).getCTTc().addNewTcPr().setHMerge(hMerge);
            hMerge.setVal(STMerge.CONTINUE);
            row.getCell(3).getCTTc().addNewTcPr().setHMerge(hMerge);
            row.getCell(4).getCTTc().addNewTcPr().setHMerge(hMerge);
            setBoldTextToHCenterVTopInCell(row.getCell(2), getSummaryOfAuditHours(speciality).toString());
            paragraph = document.insertNewParagraph(getNewCursor(document, table));
            paragraph.createRun().addCarriageReturn();
            cursor = getNewCursor(document, paragraph);
        }
        return cursor;
    }

    private void getCompetencesForSpecialities(XWPFRun run) {
        List<Speciality> specialities = queriesForReport.getSpecialitiesForExplanatoryNote(explanatoryNote);
        for (Speciality speciality : specialities) {
            List<Competence> competences = queriesForReport.
                    getCompetencesBySpecialityAndExplanatoryNote(speciality, explanatoryNote);
            if (CollectionUtils.isEmpty(competences)) {
                continue;
            }
            run.addTab();
            run.setText("для специальности " + speciality.getCode() + " «" + speciality.getName() + "»:");
            run.addCarriageReturn();
            for (Competence competence : competences) {
                run.setText(competence.getCompetenceCode().getCode() + ". " + competence.getText() + ".");
                run.addCarriageReturn();
            }
        }
        removeLastCarriageReturn(run);
    }

    private void getStudentMustsByType(StudentMustType studentMustType, XmlCursor cursor, XWPFDocument document) {
        List<StudentMust> studentMustKnows = queriesForReport.
                getStudentMustsBuStudentMustTypeAndExplanatoryNote(studentMustType, explanatoryNote);
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        set14TimesNewRomanRun(run);
        for (StudentMust studentMust : studentMustKnows) {
            run.setText("- " + studentMust.getText() + ";");
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    private void fillSummaryOfHoursTableBySpecialities(List<Speciality> specialities, XWPFTable table, String tableName) throws Exception {
        List<ActiveSpeciality> activeSpecialities = explanatoryNote.getActiveSpecialities();
        if (CollectionUtils.isEmpty(activeSpecialities)) {
            return;
        }
        XWPFTableCell cell = table.getRow(0).getCell(0);
        cell.getCTTc().addNewTcPr().addNewGridSpan().setVal(BigInteger.valueOf(6));
        setTextToHCenterVCenterInCell(cell, tableName);
        XWPFTableRow headerRow = table.createRow();
        setTextToHCenterVCenterInCell(headerRow.getCell(0), "Номер специальности");
        setTextToHCenterVCenterInCell(headerRow.createCell(), "Курс");
        setTextToHCenterVCenterInCell(headerRow.createCell(), "Семестр");
        setTextToHCenterVCenterInCell(headerRow.createCell(), "Лекции, ч.");
        setTextToHCenterVCenterInCell(headerRow.createCell(), "Лабораторные занятия, ч.");
        setTextToHCenterVCenterInCell(headerRow.createCell(), "Форма текущей аттестации");
        int firstRow = 2;
        for (Speciality speciality : specialities) {
            XWPFTableRow row = null;
            List<ActiveSpeciality> activeSpecialitiesForSpeciality = getActiveSpecialitiesForSpeciality(speciality);
            Sort.sortListByFieldAscending(activeSpecialitiesForSpeciality, "semester");
            for (ActiveSpeciality activeSpeciality : activeSpecialitiesForSpeciality) {
                row = table.createRow();
                setTextToHCenterVCenterInCell(row.getCell(0), speciality.getCode());
                setTextToHCenterVCenterInCell(row.createCell(), getCourseFromSemester(activeSpeciality.getSemester()).toString());
                setTextToHCenterVCenterInCell(row.createCell(), activeSpeciality.getSemester().toString());
                setTextToHCenterVCenterInCell(row.createCell(), getSummaryOfLectureHours(activeSpeciality).toString());
                setTextToHCenterVCenterInCell(row.createCell(), getSummaryOfLaboratoryWorkHours(activeSpeciality).toString());
                String validationCellText = (activeSpeciality.getExam() ? "экзамен" : "зачет") +
                        (activeSpeciality.getCourseProject() == null ? EMPTY_STRING : ", курсовая работа");
                setTextToHCenterVCenterInCell(row.createCell(), validationCellText);
            }
            int lastRow = table.getRows().indexOf(row);
            CTVMerge ctvMerge = CTVMerge.Factory.newInstance();
            ctvMerge.setVal(STMerge.RESTART);
            table.getRow(firstRow).getCell(0).getCTTc().getTcPr().setVMerge(ctvMerge);
            ctvMerge.setVal(STMerge.CONTINUE);
            table.getRow(lastRow).getCell(0).getCTTc().getTcPr().setVMerge(ctvMerge);
            firstRow = lastRow + 1;
        }
    }

    private CourseProject getCourseProject() {
        List<ActiveSpeciality> activeSpecialities = explanatoryNote.getActiveSpecialities();
        if (CollectionUtils.isEmpty(activeSpecialities)) {
            return null;
        }
        for (ActiveSpeciality activeSpeciality : activeSpecialities) {
            if (activeSpeciality.getCourseProject() != null) {
                return activeSpeciality.getCourseProject();
            }
        }
        return null;
    }

    private void getAcademics(List<Academic> academics, XmlCursor cursor, XWPFDocument document) {
        XWPFParagraph paragraph = document.insertNewParagraph(cursor);
        paragraph.setAlignment(ParagraphAlignment.BOTH);
        XWPFRun run = paragraph.createRun();
        for (Academic creator : academics) {
            StringBuilder builder = new StringBuilder();
            setBold14TimesNewRomanRun(run);
            run.setText(creator.getFullName() + ", ");
            Department department = queriesForReport.getDepartmentByAcademic(creator);
            University university = queriesForReport.getUniversityByDepartment(department);
            run = paragraph.createRun();
            set14TimesNewRomanRun(run);
            builder.append(creator.getPosition().getName()).
                    append(" «").
                    append(department.getName()).
                    append("» Учреждения образования «").
                    append(university.getName()).
                    append("», ").
                    append(creator.getAcademicDegree().getName()).
                    append(", ").
                    append(creator.getAcademicRank().getName()).
                    append(".");
            run.setText(builder.toString());
            run.addCarriageReturn();
        }
        removeLastCarriageReturn(run);
    }

    private List<ActiveSpeciality> getActiveSpecialitiesForSpeciality(Speciality speciality) {
        List<ActiveSpeciality> activeSpecialities = explanatoryNote.getActiveSpecialities();
        if (CollectionUtils.isEmpty(activeSpecialities)) {
            return Collections.emptyList();
        }
        List<ActiveSpeciality> result = new ArrayList<>();
        for (ActiveSpeciality activeSpeciality : activeSpecialities) {
            if (activeSpeciality.getSpeciality().getId().equals(speciality.getId())) {
                result.add(activeSpeciality);
            }
        }
        return result;
    }

    private void setBoldTextToHCenterVTopInCell(XWPFTableCell cell, String text){
        setBoldTextInCellByAlignments(cell, text, XWPFTableCell.XWPFVertAlign.TOP, ParagraphAlignment.CENTER);
    }

    private void setBoldTextToHRightrVTopInCell(XWPFTableCell cell, String text){
        setBoldTextInCellByAlignments(cell, text, XWPFTableCell.XWPFVertAlign.TOP, ParagraphAlignment.RIGHT);
    }

    private void setTextToCenterInVerticalDirectionInCell(XWPFTableCell cell, String text) {
        cell.getCTTc().addNewTcPr().addNewTextDirection().setVal(STTextDirection.BT_LR);
        setTextToHCenterVCenterInCell(cell, text);
    }

    private void setTextToHCenterVCenterInCell(XWPFTableCell cell, String text) {
        setTextInCellByAlignments(cell, text, XWPFTableCell.XWPFVertAlign.CENTER, ParagraphAlignment.CENTER);
    }

    private void setTextToHLeftVTopInCell(XWPFTableCell cell, String text) {
        setTextInCellByAlignments(cell, text, XWPFTableCell.XWPFVertAlign.TOP, ParagraphAlignment.LEFT);
    }

    private void setTextToHCenterVTopInCell(XWPFTableCell cell, String text) {
        setTextInCellByAlignments(cell, text, XWPFTableCell.XWPFVertAlign.TOP, ParagraphAlignment.CENTER);
    }

    private void setTextInCellByAlignments(XWPFTableCell cell, String text, XWPFTableCell.XWPFVertAlign vert, ParagraphAlignment hor){
        cell.setVerticalAlignment(vert);
        XWPFParagraph paragraph = cell.getParagraphs().get(0);
        paragraph.setAlignment(hor);
        XWPFRun run = paragraph.createRun();
        set12TimesNewRomanRun(run);
        run.setText(text);
    }

    private void setBoldTextInCellByAlignments(XWPFTableCell cell, String text, XWPFTableCell.XWPFVertAlign vert, ParagraphAlignment hor){
        cell.setVerticalAlignment(vert);
        XWPFParagraph paragraph = cell.getParagraphs().get(0);
        paragraph.setAlignment(hor);
        XWPFRun run = paragraph.createRun();
        setBold12TimesNewRomanRun(run);
        run.setText(text);
    }

    private Long getCourseFromSemester(Long semester) {
        long rest = semester % 2;
        return rest == 0 ? semester / 2 : (semester / 2) + 1;
    }

    private Long getSummaryOfLectureHours(ActiveSpeciality activeSpeciality) {
        Long result = 0L;
        for (ActiveTopic activeTopic : activeSpeciality.getActiveTopics()) {
            result += activeTopic.getLectureHours();
        }
        return result;
    }

    private Long getSummaryOfLaboratoryWorkHours(ActiveSpeciality activeSpeciality) {
        Long result = 0L;
        for (ActiveTopic activeTopic : activeSpeciality.getActiveTopics()) {
            result += activeTopic.getLaboratoryWorkHours();
        }
        return result;
    }

    private Long getSummaryOfOtherHours(ActiveSpeciality activeSpeciality) {
        Long result = 0L;
        for (ActiveTopic activeTopic : activeSpeciality.getActiveTopics()) {
            result += activeTopic.getOtherHours();
        }
        return result;
    }

    private Long getSummaryOfUsrHours(ActiveSpeciality activeSpeciality) {
        Long result = 0L;
        for (ActiveTopic activeTopic : activeSpeciality.getActiveTopics()) {
            result += activeTopic.getUsrHours();
        }
        return result;
    }

    private Long getSummaryOfAuditHours(Speciality speciality){
        List<ActiveSpeciality> activeSpecialities = getActiveSpecialitiesForSpeciality(speciality);
        long auditHours = 0L;
        for(ActiveSpeciality activeSpeciality: activeSpecialities){
            auditHours += getSummaryOfLectureHours(activeSpeciality) + getSummaryOfLaboratoryWorkHours(activeSpeciality) +
                    getSummaryOfOtherHours(activeSpeciality);
        }
        return auditHours;
    }

    private void removeLastCarriageReturn(XWPFRun run) {
        run.getCTR().removeCr(run.getCTR().sizeOfCrArray() - 1);
    }

    private String getHoursInString(Long hours){
        return hours == 0 ? EMPTY_STRING : hours.toString();
    }

    private void createEmptyCells(XWPFTableRow row, int count){
        for(int i = 0; i < count; i++){
            row.createCell();
        }
    }

    @Override
    public String getFileName() {
        return explanatoryNote.getName();
    }

    private void setBold16TimesNewRomanRun(XWPFRun run) {
        run.setBold(true);
        run.setItalic(false);
        run.setFontSize(16);
        run.setFontFamily("Times New Roman");
    }

    private void setBold14TimesNewRomanRun(XWPFRun run) {
        run.setBold(true);
        run.setItalic(false);
        run.setFontSize(14);
        run.setFontFamily("Times New Roman");
    }

    private void set14TimesNewRomanRun(XWPFRun run) {
        run.setBold(false);
        run.setItalic(false);
        run.setFontSize(14);
        run.setFontFamily("Times New Roman");
    }

    private void set12TimesNewRomanRun(XWPFRun run) {
        run.setBold(false);
        run.setItalic(false);
        run.setFontSize(12);
        run.setFontFamily("Times New Roman");
    }

    private void setBold12TimesNewRomanRun(XWPFRun run) {
        run.setBold(true);
        run.setItalic(false);
        run.setFontSize(12);
        run.setFontFamily("Times New Roman");
    }
}
