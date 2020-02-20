package com.bntu.fitr.poit.zholudev.diplom.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "control_questions")
public class ControlQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long questionNumber;
    private String text;
    private Long explanatoryNoteId;

    public ControlQuestion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Long questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getExplanatoryNoteId() {
        return explanatoryNoteId;
    }

    public void setExplanatoryNoteId(Long explanatoryNoteId) {
        this.explanatoryNoteId = explanatoryNoteId;
    }
}
