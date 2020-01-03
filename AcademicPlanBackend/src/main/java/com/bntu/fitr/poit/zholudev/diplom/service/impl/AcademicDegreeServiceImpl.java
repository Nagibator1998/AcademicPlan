package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.AcademicDegree;
import com.bntu.fitr.poit.zholudev.diplom.repository.AcademicDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.ACADEMIC_DEGREE_NAME)
public class AcademicDegreeServiceImpl extends EntityServiceImpl<AcademicDegree> {

    @Autowired
    public AcademicDegreeServiceImpl(AcademicDegreeRepository repository) {
        this.repository = repository;
    }
}
