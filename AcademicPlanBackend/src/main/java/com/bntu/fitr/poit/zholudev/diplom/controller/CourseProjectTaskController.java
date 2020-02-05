package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProjectTask;
import com.bntu.fitr.poit.zholudev.diplom.service.CourseProjectService;
import com.bntu.fitr.poit.zholudev.diplom.service.CourseProjectTaskService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.COURSE_PROJECT_TASK_NAME)
public class CourseProjectTaskController extends EntityController<CourseProjectTask, CourseProjectTaskService> {
    @Autowired
    public CourseProjectTaskController(CourseProjectTaskService service) {
        this.service = service;
    }
}
