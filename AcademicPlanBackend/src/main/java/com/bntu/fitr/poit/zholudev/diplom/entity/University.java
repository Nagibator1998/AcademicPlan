package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String abbreviation;
    @OneToOne
    private Academic viceRectorForEducationalWork;
    @OneToMany(mappedBy = "universityId")
    private Set<Faculty> faculties;

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

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }
}
