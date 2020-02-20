package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "laboratory_works")
public class LaboratoryWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long workNumber;
    private Long explanatoryNoteId;

    public LaboratoryWork() {
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

    public Long getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(Long workNumber) {
        this.workNumber = workNumber;
    }

    public Long getExplanatoryNoteId() {
        return explanatoryNoteId;
    }

    public void setExplanatoryNoteId(Long explanatoryNoteId) {
        this.explanatoryNoteId = explanatoryNoteId;
    }
}
