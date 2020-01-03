package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.StudentMustEntity;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.STUDENT_MUST_ENTITY_NAME)
public class StudentMustEntityController extends EntityController<StudentMustEntity> {

    @Autowired
    public StudentMustEntityController(@Qualifier(EntityConstants.STUDENT_MUST_ENTITY_NAME) EntityService<StudentMustEntity> service) {
        this.service = service;
    }

}
