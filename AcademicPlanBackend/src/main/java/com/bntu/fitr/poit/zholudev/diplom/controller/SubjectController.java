package com.bntu.fitr.poit.zholudev.diplom.controller;


import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Subject;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import com.bntu.fitr.poit.zholudev.diplom.service.StudentMustService;
import com.bntu.fitr.poit.zholudev.diplom.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.SUBJECT_NAME)
public class SubjectController extends EntityController<Subject, SubjectService> {
    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }
}
