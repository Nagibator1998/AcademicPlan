package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.StudentMustType;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.STUDENT_MUST_TYPE_NAME)
public class StudentMustTypeController extends EntityController<StudentMustType> {

    @Autowired
    public StudentMustTypeController(@Qualifier(EntityConstants.STUDENT_MUST_TYPE_NAME) EntityService<StudentMustType> service) {
        this.service = service;
    }

}
