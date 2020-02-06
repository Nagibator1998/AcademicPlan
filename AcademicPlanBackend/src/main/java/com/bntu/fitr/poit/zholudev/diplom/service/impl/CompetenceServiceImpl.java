package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Competence;
import com.bntu.fitr.poit.zholudev.diplom.repository.CompetenceRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service(EntityConstants.COMPETENCE_NAME)
public class CompetenceServiceImpl extends EntityServiceImpl<Competence, CompetenceRepository>
        implements CompetenceService {

    @Autowired
    public CompetenceServiceImpl(CompetenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Competence> getCompetencesForExplanatoryNote(Long explanatoryNoteId) {
        return this.repository.getCompetencesForExplanatoryNote(explanatoryNoteId);
    }
}
