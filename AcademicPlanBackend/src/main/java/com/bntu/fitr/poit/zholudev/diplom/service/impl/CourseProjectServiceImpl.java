package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProject;
import com.bntu.fitr.poit.zholudev.diplom.repository.CourseProjectRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.CourseProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.COURSE_PROJECT_NAME)
public class CourseProjectServiceImpl extends EntityServiceImpl<CourseProject, CourseProjectRepository>
        implements CourseProjectService {

    @Autowired
    public CourseProjectServiceImpl(CourseProjectRepository repository) {
        this.repository = repository;
    }
}
