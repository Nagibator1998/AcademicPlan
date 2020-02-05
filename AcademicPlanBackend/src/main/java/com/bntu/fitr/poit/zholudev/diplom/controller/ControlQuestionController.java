package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ControlQuestion;
import com.bntu.fitr.poit.zholudev.diplom.service.CompetenceService;
import com.bntu.fitr.poit.zholudev.diplom.service.ControlQuestionService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.CONTROL_QUESTION_NAME)
public class ControlQuestionController extends EntityController<ControlQuestion, ControlQuestionService> {
    @Autowired
    public ControlQuestionController(ControlQuestionService service) {
        this.service = service;
    }
}
