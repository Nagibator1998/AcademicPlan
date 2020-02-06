package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Topic;
import com.bntu.fitr.poit.zholudev.diplom.repository.TopicRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.TOPIC_NAME)
public class TopicServiceImpl extends EntityServiceImpl<Topic, TopicRepository> implements TopicService {

    @Autowired
    public TopicServiceImpl(TopicRepository repository) {
        this.repository = repository;
    }
}
