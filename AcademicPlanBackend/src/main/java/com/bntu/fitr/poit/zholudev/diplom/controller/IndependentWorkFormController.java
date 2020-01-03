package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.IndependentWorkForm;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.INDEPENDENT_WORK_FORM_NAME)
public class IndependentWorkFormController extends EntityController<IndependentWorkForm> {

    @Autowired
    public IndependentWorkFormController(@Qualifier(EntityConstants.INDEPENDENT_WORK_FORM_NAME) EntityService<IndependentWorkForm> service) {
        this.service = service;
    }

}
