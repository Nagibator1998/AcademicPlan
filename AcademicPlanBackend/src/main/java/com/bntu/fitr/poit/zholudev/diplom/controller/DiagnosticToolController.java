package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.DiagnosticTool;
import com.bntu.fitr.poit.zholudev.diplom.service.DepartmentService;
import com.bntu.fitr.poit.zholudev.diplom.service.DiagnosticToolService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.DIAGNOSTIC_TOOL_NAME)
public class DiagnosticToolController extends EntityController<DiagnosticTool, DiagnosticToolService> {
    @Autowired
    public DiagnosticToolController(DiagnosticToolService service) {
        this.service = service;
    }
}
