package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CompetenceCode;
import com.bntu.fitr.poit.zholudev.diplom.service.ActiveTopicService;
import com.bntu.fitr.poit.zholudev.diplom.service.CompetenceCodeService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.COMPETENCE_CODE_NAME)
public class CompetenceCodeController extends EntityController<CompetenceCode, CompetenceCodeService> {
    @Autowired
    public CompetenceCodeController(CompetenceCodeService service) {
        this.service = service;
    }
}
