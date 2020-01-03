package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProjectTask;
import com.bntu.fitr.poit.zholudev.diplom.repository.CourseProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.COURSE_PROJECT_TASK_NAME)
public class CourseProjectTaskServiceImpl extends EntityServiceImpl<CourseProjectTask> {

    @Autowired

    public CourseProjectTaskServiceImpl(CourseProjectTaskRepository repository) {
        this.repository = repository;
    }
}
