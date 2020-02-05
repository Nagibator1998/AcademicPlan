package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProject;
import com.bntu.fitr.poit.zholudev.diplom.service.ControlQuestionService;
import com.bntu.fitr.poit.zholudev.diplom.service.CourseProjectService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.COURSE_PROJECT_NAME)
public class CourseProjectController extends EntityController<CourseProject, CourseProjectService> {
    @Autowired
    public CourseProjectController(CourseProjectService service) {
        this.service = service;
    }
}
