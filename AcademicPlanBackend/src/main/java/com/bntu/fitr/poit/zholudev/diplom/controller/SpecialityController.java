package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Speciality;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.SPECIALITY_NAME)
public class SpecialityController extends EntityController<Speciality> {

    @Autowired
    public SpecialityController(@Qualifier(EntityConstants.SPECIALITY_NAME) EntityService<Speciality> service) {
        this.service = service;
    }
}
