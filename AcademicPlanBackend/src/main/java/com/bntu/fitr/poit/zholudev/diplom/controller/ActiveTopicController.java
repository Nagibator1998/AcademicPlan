package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveTopic;
import com.bntu.fitr.poit.zholudev.diplom.service.AcademicRankService;
import com.bntu.fitr.poit.zholudev.diplom.service.ActiveTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACTIVE_TOPIC_NAME)
public class ActiveTopicController extends EntityController<ActiveTopic, ActiveTopicService> {
    @Autowired
    public ActiveTopicController(ActiveTopicService service) {
        this.service = service;
    }
}
