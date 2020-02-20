package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "active_specialities")
public class ActiveSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long explanatoryNoteId;
    @ManyToOne
    private Speciality speciality;
    private Long semester;
    private Boolean exam;
    @ManyToOne(cascade = CascadeType.ALL)
    private CourseProject courseProject;
    @OneToMany(mappedBy = "activeSpecialityId", cascade = CascadeType.ALL)
    private List<ActiveTopic> activeTopics;

    public ActiveSpeciality() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExplanatoryNoteId() {
        return explanatoryNoteId;
    }

    public void setExplanatoryNoteId(Long explanatoryNoteId) {
        this.explanatoryNoteId = explanatoryNoteId;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Long getSemester() {
        return semester;
    }

    public void setSemester(Long semester) {
        this.semester = semester;
    }

    public Boolean getExam() {
        return exam;
    }

    public void setExam(Boolean exam) {
        this.exam = exam;
    }

    public CourseProject getCourseProject() {
        return courseProject;
    }

    public void setCourseProject(CourseProject courseProject) {
        this.courseProject = courseProject;
    }

    public List<ActiveTopic> getActiveTopics() {
        return activeTopics;
    }

    public void setActiveTopics(List<ActiveTopic> activeTopics) {
        this.activeTopics = activeTopics;
    }
}
