package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import com.bntu.fitr.poit.zholudev.diplom.repository.ExplanatoryNoteRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.ExplanatoryNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.EXPLANATORY_NOTE_NAME)
public class ExplanatoryNoteServiceImpl extends EntityServiceImpl<ExplanatoryNote, ExplanatoryNoteRepository>
        implements ExplanatoryNoteService {

    @Autowired
    public ExplanatoryNoteServiceImpl(ExplanatoryNoteRepository repository) {
        this.repository = repository;
    }
}
