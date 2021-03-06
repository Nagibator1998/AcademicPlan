package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.DiagnosticTool;
import com.bntu.fitr.poit.zholudev.diplom.repository.DiagnosticToolRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.DiagnosticToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.DIAGNOSTIC_TOOL_NAME)
public class DiagnosticToolServiceImpl extends EntityServiceImpl<DiagnosticTool, DiagnosticToolRepository>
        implements DiagnosticToolService {

    @Autowired
    public DiagnosticToolServiceImpl(DiagnosticToolRepository repository) {
        this.repository = repository;
    }
}
