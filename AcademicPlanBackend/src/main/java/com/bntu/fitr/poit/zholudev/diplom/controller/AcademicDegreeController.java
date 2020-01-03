package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.AcademicDegree;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACADEMIC_DEGREE_NAME)
public class AcademicDegreeController extends EntityController<AcademicDegree> {

    @Autowired
    public AcademicDegreeController(@Qualifier(EntityConstants.ACADEMIC_DEGREE_NAME) EntityService<AcademicDegree> service) {
        this.service = service;
    }

}
