package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Academic;
import com.bntu.fitr.poit.zholudev.diplom.service.AcademicService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACADEMIC_NAME)
public class AcademicController extends EntityController<Academic, AcademicService> {

    @Autowired
    public AcademicController(AcademicService service){
        this.service = service;
    }

}
