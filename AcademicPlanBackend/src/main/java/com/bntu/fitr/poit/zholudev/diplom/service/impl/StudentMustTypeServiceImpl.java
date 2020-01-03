package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.StudentMustType;
import com.bntu.fitr.poit.zholudev.diplom.repository.StudentMustTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.STUDENT_MUST_TYPE_NAME)
public class StudentMustTypeServiceImpl extends EntityServiceImpl<StudentMustType> {
    @Autowired

    public StudentMustTypeServiceImpl(StudentMustTypeRepository repository) {
        this.repository = repository;
    }
}
