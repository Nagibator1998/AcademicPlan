package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Literature;
import com.bntu.fitr.poit.zholudev.diplom.repository.LiteratureRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.LITERATURE_NAME)
public class LiteratureServiceImpl extends EntityServiceImpl<Literature> implements LiteratureService {

    @Autowired
    public LiteratureServiceImpl(LiteratureRepository repository) {
        this.repository = repository;
    }
}
