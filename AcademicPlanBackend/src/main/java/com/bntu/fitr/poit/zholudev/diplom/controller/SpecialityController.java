package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Speciality;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import com.bntu.fitr.poit.zholudev.diplom.service.SectionService;
import com.bntu.fitr.poit.zholudev.diplom.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.SPECIALITY_NAME)
public class SpecialityController extends EntityController<Speciality, SpecialityService> {
    @Autowired
    public SpecialityController(SpecialityService service) {
        this.service = service;
    }
}
