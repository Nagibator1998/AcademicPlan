package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.StudentMust;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import com.bntu.fitr.poit.zholudev.diplom.service.StandardService;
import com.bntu.fitr.poit.zholudev.diplom.service.StudentMustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.STUDENT_MUST_ENTITY_NAME)
public class StudentMustController extends EntityController<StudentMust, StudentMustService> {
    @Autowired
    public StudentMustController(StudentMustService service) {
        this.service = service;
    }
}
