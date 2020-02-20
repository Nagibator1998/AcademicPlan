package com.bntu.fitr.poit.zholudev.diplom.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "explanatory_notes")

public class ExplanatoryNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Subject subject;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Competence> competences;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<DiagnosticTool> diagnosticTools;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<IndependentWorkForm> independentWorkForms;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Literature> basicLiterature;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Literature> additionalLiterature;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<StudentMust> studentMusts;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Academic> reviewers;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Academic> creators;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Standard> standards;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private List<ActiveSpeciality> activeSpecialities;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private List<ControlQuestion> controlQuestions;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private List<LaboratoryWork> laboratoryWorks;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private List<Section> sections;

    public ExplanatoryNote() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<DiagnosticTool> getDiagnosticTools() {
        return diagnosticTools;
    }

    public void setDiagnosticTools(List<DiagnosticTool> diagnosticTools) {
        this.diagnosticTools = diagnosticTools;
    }

    public List<IndependentWorkForm> getIndependentWorkForms() {
        return independentWorkForms;
    }

    public void setIndependentWorkForms(List<IndependentWorkForm> independentWorkForms) {
        this.independentWorkForms = independentWorkForms;
    }

    public List<Literature> getBasicLiterature() {
        return basicLiterature;
    }

    public void setBasicLiterature(List<Literature> basicLiterature) {
        this.basicLiterature = basicLiterature;
    }

    public List<Literature> getAdditionalLiterature() {
        return additionalLiterature;
    }

    public void setAdditionalLiterature(List<Literature> additionalLiterature) {
        this.additionalLiterature = additionalLiterature;
    }

    public List<StudentMust> getStudentMusts() {
        return studentMusts;
    }

    public void setStudentMusts(List<StudentMust> studentMusts) {
        this.studentMusts = studentMusts;
    }

    public List<Academic> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Academic> reviewers) {
        this.reviewers = reviewers;
    }

    public List<Academic> getCreators() {
        return creators;
    }

    public void setCreators(List<Academic> creators) {
        this.creators = creators;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public void setStandards(List<Standard> standards) {
        this.standards = standards;
    }

    public List<ActiveSpeciality> getActiveSpecialities() {
        return activeSpecialities;
    }

    public void setActiveSpecialities(List<ActiveSpeciality> activeSpecialities) {
        this.activeSpecialities = activeSpecialities;
    }

    public List<ControlQuestion> getControlQuestions() {
        return controlQuestions;
    }

    public void setControlQuestions(List<ControlQuestion> controlQuestions) {
        this.controlQuestions = controlQuestions;
    }

    public List<LaboratoryWork> getLaboratoryWorks() {
        return laboratoryWorks;
    }

    public void setLaboratoryWorks(List<LaboratoryWork> laboratoryWorks) {
        this.laboratoryWorks = laboratoryWorks;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
