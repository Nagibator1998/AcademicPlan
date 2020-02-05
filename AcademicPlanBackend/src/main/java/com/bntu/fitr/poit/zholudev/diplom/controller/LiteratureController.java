package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Literature;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import com.bntu.fitr.poit.zholudev.diplom.service.LaboratoryWorkService;
import com.bntu.fitr.poit.zholudev.diplom.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.LITERATURE_NAME)
public class LiteratureController extends EntityController<Literature, LiteratureService> {
    @Autowired
    public LiteratureController(LiteratureService service) {
        this.service = service;
    }
}
