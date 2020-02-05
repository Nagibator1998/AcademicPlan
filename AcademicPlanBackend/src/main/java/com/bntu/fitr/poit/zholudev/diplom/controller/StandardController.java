package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Standard;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import com.bntu.fitr.poit.zholudev.diplom.service.SpecialityService;
import com.bntu.fitr.poit.zholudev.diplom.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.STANDARD_NAME)
public class StandardController extends EntityController<Standard, StandardService> {
    @Autowired
    public StandardController(StandardService service) {
        this.service = service;
    }
}
