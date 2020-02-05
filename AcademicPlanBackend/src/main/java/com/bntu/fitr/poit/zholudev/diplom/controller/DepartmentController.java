package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Department;
import com.bntu.fitr.poit.zholudev.diplom.service.CourseProjectTaskService;
import com.bntu.fitr.poit.zholudev.diplom.service.DepartmentService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.DEPARTMENT_NAME)
public class DepartmentController extends EntityController<Department, DepartmentService> {
    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

}
