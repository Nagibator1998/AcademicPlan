package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveTopic;
import com.bntu.fitr.poit.zholudev.diplom.repository.ActiveTopicRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.ActiveTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.ACTIVE_TOPIC_NAME)
public class ActiveTopicServiceImpl extends EntityServiceImpl<ActiveTopic, ActiveTopicRepository>
        implements ActiveTopicService {

    @Autowired
    public ActiveTopicServiceImpl(ActiveTopicRepository repository) {
        this.repository = repository;
    }
}
