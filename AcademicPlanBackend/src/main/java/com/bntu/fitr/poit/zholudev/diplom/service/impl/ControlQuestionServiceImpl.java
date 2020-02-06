package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ControlQuestion;
import com.bntu.fitr.poit.zholudev.diplom.repository.ControlQuestionRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.ControlQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.CONTROL_QUESTION_NAME)
public class ControlQuestionServiceImpl extends EntityServiceImpl<ControlQuestion, ControlQuestionRepository>
        implements ControlQuestionService {

    @Autowired
    public ControlQuestionServiceImpl(ControlQuestionRepository repository) {
        this.repository = repository;
    }
}
