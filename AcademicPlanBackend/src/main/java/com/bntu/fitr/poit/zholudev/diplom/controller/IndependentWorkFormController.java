package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.IndependentWorkForm;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import com.bntu.fitr.poit.zholudev.diplom.service.FacultyService;
import com.bntu.fitr.poit.zholudev.diplom.service.IndependentWorkFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.INDEPENDENT_WORK_FORM_NAME)
public class IndependentWorkFormController extends EntityController<IndependentWorkForm, IndependentWorkFormService> {
    @Autowired
    public IndependentWorkFormController(IndependentWorkFormService service) {
        this.service = service;
    }
}
