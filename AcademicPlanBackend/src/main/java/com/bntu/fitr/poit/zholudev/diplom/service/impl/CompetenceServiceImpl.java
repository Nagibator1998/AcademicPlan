package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Competence;
import com.bntu.fitr.poit.zholudev.diplom.repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.COMPETENCE_NAME)
public class CompetenceServiceImpl extends EntityServiceImpl<Competence> {

    @Autowired
    public CompetenceServiceImpl(CompetenceRepository repository){
        this.repository = repository;
    }
}
