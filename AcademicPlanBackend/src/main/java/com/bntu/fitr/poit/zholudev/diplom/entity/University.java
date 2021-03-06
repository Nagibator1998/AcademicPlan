package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String abbreviation;
    @OneToOne
    private Academic viceRectorForEducationalWork;
    @OneToMany(mappedBy = "universityId")
    private List<Faculty> faculties;

    public University() {
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

    public Academic getViceRectorForEducationalWork() {
        return viceRectorForEducationalWork;
    }

    public void setViceRectorForEducationalWork(Academic viceRectorForEducationalWork) {
        this.viceRectorForEducationalWork = viceRectorForEducationalWork;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
