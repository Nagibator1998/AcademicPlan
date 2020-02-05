package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProjectTopic;
import com.bntu.fitr.poit.zholudev.diplom.repository.CourseProjectTopicRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.CourseProjectTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.COURSE_PROJECT_TOPIC_NAME)
public class CourseProjectTopicServiceImpl extends EntityServiceImpl<CourseProjectTopic> implements CourseProjectTopicService {

    @Autowired
    public CourseProjectTopicServiceImpl(CourseProjectTopicRepository repository) {
        this.repository = repository;
    }
}
