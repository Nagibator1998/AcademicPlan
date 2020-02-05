package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.StudentMust;
import com.bntu.fitr.poit.zholudev.diplom.repository.StudentMustEntityRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.StudentMustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.STUDENT_MUST_ENTITY_NAME)
public class StudentMustServiceImpl extends EntityServiceImpl<StudentMust> implements StudentMustService {

    @Autowired
    public StudentMustServiceImpl(StudentMustEntityRepository repository) {
        this.repository = repository;
    }
}
