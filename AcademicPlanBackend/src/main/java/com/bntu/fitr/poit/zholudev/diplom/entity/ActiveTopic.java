package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "active_topic")
public class ActiveTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long activeSpecialityId;
    @ManyToOne
    private Topic topic;
    private Long lectureHours;
    private Long laboratoryWorkHours;
    private Long otherHours;
    private Long usrHours;
    private Boolean defense;

    public ActiveTopic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActiveSpecialityId() {
        return activeSpecialityId;
    }

    public void setActiveSpecialityId(Long activeSpecialityId) {
        this.activeSpecialityId = activeSpecialityId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getLectureHours() {
        return lectureHours;
    }

    public void setLectureHours(Long lectionHours) {
        this.lectureHours = lectionHours;
    }

    public Long getLaboratoryWorkHours() {
        return laboratoryWorkHours;
    }

    public void setLaboratoryWorkHours(Long laboratoryWorkHours) {
        this.laboratoryWorkHours = laboratoryWorkHours;
    }

    public Long getOtherHours() {
        return otherHours;
    }

    public void setOtherHours(Long otherHours) {
        this.otherHours = otherHours;
    }

    public Long getUsrHours() {
        return usrHours;
    }

    public void setUsrHours(Long usrHours) {
        this.usrHours = usrHours;
    }

    public Boolean getDefense() {
        return defense;
    }

    public void setDefense(Boolean defense) {
        this.defense = defense;
    }
}
