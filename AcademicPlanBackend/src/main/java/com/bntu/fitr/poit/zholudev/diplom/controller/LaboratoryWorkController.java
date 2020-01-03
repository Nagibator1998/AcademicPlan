package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.LaboratoryWork;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.LABORATORY_WORK_NAME)
public class LaboratoryWorkController extends EntityController<LaboratoryWork> {

    @Autowired
    public LaboratoryWorkController(@Qualifier(EntityConstants.LABORATORY_WORK_NAME) EntityService<LaboratoryWork> service) {
        this.service = service;
    }

}
