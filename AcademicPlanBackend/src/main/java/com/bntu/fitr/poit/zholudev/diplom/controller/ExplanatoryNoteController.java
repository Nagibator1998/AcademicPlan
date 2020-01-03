package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.EXPLANATORY_NOTE_NAME)
public class ExplanatoryNoteController extends EntityController<ExplanatoryNote> {

    @Autowired
    public ExplanatoryNoteController(@Qualifier(EntityConstants.EXPLANATORY_NOTE_NAME) EntityService<ExplanatoryNote> service) {
        this.service = service;
    }

}
