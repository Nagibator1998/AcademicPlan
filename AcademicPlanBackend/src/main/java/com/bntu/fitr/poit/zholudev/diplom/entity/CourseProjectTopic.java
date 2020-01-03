package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "course_project_topics")
public class CourseProjectTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long topicNumber;
    private String text;
    private Long courseProjectId;

    public CourseProjectTopic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicNumber() {
        return topicNumber;
    }

    public void setTopicNumber(Long topicNumber) {
        this.topicNumber = topicNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCourseProjectId() {
        return courseProjectId;
    }

    public void setCourseProjectId(Long courseProjectId) {
        this.courseProjectId = courseProjectId;
    }
}
