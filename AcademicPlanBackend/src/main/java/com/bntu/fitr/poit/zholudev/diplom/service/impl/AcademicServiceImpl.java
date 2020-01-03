package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Academic;
import com.bntu.fitr.poit.zholudev.diplom.repository.AcademicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.ACADEMIC_NAME)
public class AcademicServiceImpl extends EntityServiceImpl<Academic> {

    @Autowired
    public AcademicServiceImpl (AcademicRepository repository) {
        this.repository = repository;
    }

}
