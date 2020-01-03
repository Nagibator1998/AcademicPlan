package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String abbreviation;
    private Long universityId;
    @OneToOne
    private Academic methodicalCommissionChairman;
    @OneToMany
    private Set<Department> departments;


    public Faculty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Academic getMethodicalCommissionChairman() {
        return methodicalCommissionChairman;
    }

    public void setMethodicalCommissionChairman(Academic methodicalCommissionChairman) {
        this.methodicalCommissionChairman = methodicalCommissionChairman;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
