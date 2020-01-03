package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveSpeciality;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACTIVE_SPECIALITY_NAME)
public class ActiveSpecialityController extends EntityController<ActiveSpeciality> {

    @Autowired
    public ActiveSpecialityController(@Qualifier(EntityConstants.ACTIVE_SPECIALITY_NAME) EntityService<ActiveSpeciality> service) {
        this.service = service;
    }

}


