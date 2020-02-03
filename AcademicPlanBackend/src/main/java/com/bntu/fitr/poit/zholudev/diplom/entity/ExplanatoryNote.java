package com.bntu.fitr.poit.zholudev.diplom.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "explanatory_notes")

public class ExplanatoryNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String text;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Subject subject;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Competence> competences;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<DiagnosticTool> diagnosticTools;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<IndependentWorkForm> independentWorkForms;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Literature> basicLiterature;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Literature> additionalLiterature;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<StudentMust> studentMusts;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Academic> reviewers;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Academic> creators;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Standard> standards;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private Set<ActiveSpeciality> activeSpecialities;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private Set<ControlQuestion> controlQuestions;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private Set<LaboratoryWork> laboratoryWorks;
    @OneToMany(mappedBy = "explanatoryNoteId")
    private Set<Section> sections;

    public ExplanatoryNote() {
    }

    public Set<Academic> getCreators() {
        return creators;
    }

    public void setCreators(Set<Academic> creators) {
        this.creators = creators;
    }

    public Set<Section> getSections() {
        return sections;
    }

    public void setSections(Set<Section> sections) {
        this.sections = sections;
    }

    public Set<Academic> getReviewers() {
        return reviewers;
    }

    public void setReviewers(Set<Academic> reviewers) {
        this.reviewers = reviewers;
    }

    public Set<ControlQuestion> getControlQuestions() {
        return controlQuestions;
    }

    public void setControlQuestions(Set<ControlQuestion> controlQuestions) {
        this.controlQuestions = controlQuestions;
    }

    public Set<LaboratoryWork> getLaboratoryWorks() {
        return laboratoryWorks;
    }

    public void setLaboratoryWorks(Set<LaboratoryWork> laboratoryWorks) {
        this.laboratoryWorks = laboratoryWorks;
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

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DiagnosticTool> getDiagnosticTools() {
        return diagnosticTools;
    }

    public void setDiagnosticTools(Set<DiagnosticTool> diagnosticTools) {
        this.diagnosticTools = diagnosticTools;
    }

    public Set<IndependentWorkForm> getIndependentWorkForms() {
        return independentWorkForms;
    }

    public void setIndependentWorkForms(Set<IndependentWorkForm> independentWorkForms) {
        this.independentWorkForms = independentWorkForms;
    }

    public Set<Literature> getBasicLiterature() {
        return basicLiterature;
    }

    public void setBasicLiterature(Set<Literature> basicLiterature) {
        this.basicLiterature = basicLiterature;
    }

    public Set<Literature> getAdditionalLiterature() {
        return additionalLiterature;
    }

    public void setAdditionalLiterature(Set<Literature> additionalLiterature) {
        this.additionalLiterature = additionalLiterature;
    }

    public Set<StudentMust> getStudentMusts() {
        return studentMusts;
    }

    public void setStudentMusts(Set<StudentMust> studentMusts) {
        this.studentMusts = studentMusts;
    }

    public Set<Standard> getStandards() {
        return standards;
    }

    public void setStandards(Set<Standard> standards) {
        this.standards = standards;
    }

    public Set<ActiveSpeciality> getActiveSpecialities() {
        return activeSpecialities;
    }

    public void setActiveSpecialities(Set<ActiveSpeciality> activeSpecialities) {
        this.activeSpecialities = activeSpecialities;
    }
}
