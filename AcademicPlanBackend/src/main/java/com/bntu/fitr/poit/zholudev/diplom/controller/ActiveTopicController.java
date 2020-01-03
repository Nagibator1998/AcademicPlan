package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveTopic;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.ACTIVE_TOPIC_NAME)
public class ActiveTopicController extends EntityController<ActiveTopic> {

    @Autowired
    public ActiveTopicController(@Qualifier(EntityConstants.ACTIVE_TOPIC_NAME) EntityService<ActiveTopic> service) {
        this.service = service;
    }

}
