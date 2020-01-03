package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Subject;
import com.bntu.fitr.poit.zholudev.diplom.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.SUBJECT_NAME)
public class SubjectServiceImpl extends EntityServiceImpl<Subject> {
    @Autowired

    public SubjectServiceImpl(SubjectRepository repository) {
        this.repository = repository;
    }
}
