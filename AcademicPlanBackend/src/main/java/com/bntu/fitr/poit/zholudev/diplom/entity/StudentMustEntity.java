package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "student_musts")
public class StudentMustEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    private StudentMustType studentMustType;

    public StudentMustEntity() {
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

    public StudentMustType getStudentMustType() {
        return studentMustType;
    }

    public void setStudentMustType(StudentMustType studentMustType) {
        this.studentMustType = studentMustType;
    }
}
