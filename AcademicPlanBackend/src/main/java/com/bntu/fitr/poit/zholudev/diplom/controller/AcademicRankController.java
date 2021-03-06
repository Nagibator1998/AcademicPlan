package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.AcademicRank;
import com.bntu.fitr.poit.zholudev.diplom.service.AcademicDegreeService;
import com.bntu.fitr.poit.zholudev.diplom.service.AcademicRankService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACADEMIC_RANK_NAME)
public class AcademicRankController extends EntityController<AcademicRank, AcademicRankService> {

    @Autowired
    public AcademicRankController(AcademicRankService service) {
        this.service = service;
    }
}

