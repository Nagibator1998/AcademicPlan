package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Faculty;
import com.bntu.fitr.poit.zholudev.diplom.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.FACULTY_NAME)
public class FacultyServiceImpl extends EntityServiceImpl<Faculty> {
    @Autowired

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }
}
