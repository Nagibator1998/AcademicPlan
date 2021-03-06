package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "student_must_types")
public class StudentMustType {

    @Id
    private Long id;
    private String type;

    public StudentMustType() {
    }

    public StudentMustType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
