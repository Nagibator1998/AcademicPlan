package com.bntu.fitr.poit.zholudev.diplom.entity;


import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "competence_codes")
public class CompetenceCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;

    public CompetenceCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
