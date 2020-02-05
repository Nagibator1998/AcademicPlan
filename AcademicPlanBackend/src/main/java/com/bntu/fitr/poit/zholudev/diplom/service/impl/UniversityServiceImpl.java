package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.University;
import com.bntu.fitr.poit.zholudev.diplom.repository.UniversityRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.UNIVERSITY_NAME)
public class UniversityServiceImpl extends EntityServiceImpl<University> implements UniversityService {

    @Autowired
    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
    }
}
