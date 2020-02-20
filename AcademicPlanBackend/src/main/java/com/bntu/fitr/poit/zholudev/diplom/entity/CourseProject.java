package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course_projects")
public class CourseProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String goal;
    private Long countOfPages;
    private Long countOfHours;
    @OneToMany(mappedBy = "id")
    private List<CourseProjectTask> courseProjectTasks;
    @OneToMany(mappedBy = "id")
    private List<CourseProjectTopic> courseProjectTopics;


    public CourseProject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Long getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(Long countOfPages) {
        this.countOfPages = countOfPages;
    }

    public Long getCountOfHours() {
        return countOfHours;
    }

    public void setCountOfHours(Long countOfHours) {
        this.countOfHours = countOfHours;
    }

    public List<CourseProjectTask> getCourseProjectTasks() {
        return courseProjectTasks;
    }

    public void setCourseProjectTasks(List<CourseProjectTask> courseProjectTasks) {
        this.courseProjectTasks = courseProjectTasks;
    }

    public List<CourseProjectTopic> getCourseProjectTopics() {
        return courseProjectTopics;
    }

    public void setCourseProjectTopics(List<CourseProjectTopic> courseProjectTopics) {
        this.courseProjectTopics = courseProjectTopics;
    }
}
