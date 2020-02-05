package com.bntu.fitr.poit.zholudev.diplom.service;

import com.bntu.fitr.poit.zholudev.diplom.entity.Competence;

import java.util.Collection;

public interface CompetenceService extends EntityService<Competence> {

    Collection<Competence> getCompetencesForExplanatoryNote(Long explanatoryNoteId);
}
