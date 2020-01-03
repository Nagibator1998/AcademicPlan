package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CompetenceCode;
import com.bntu.fitr.poit.zholudev.diplom.repository.CompetenceCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.COMPETENCE_CODE_NAME)
public class CompetenceCodeServiceImpl extends EntityServiceImpl<CompetenceCode> {

    @Autowired
    public CompetenceCodeServiceImpl(CompetenceCodeRepository repository){
        this.repository = repository;
    }
}
