package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.IndependentWorkForm;
import com.bntu.fitr.poit.zholudev.diplom.repository.IndependentWorkFormRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.IndependentWorkFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.INDEPENDENT_WORK_FORM_NAME)
public class IndependentWorkFormServiceImpl extends EntityServiceImpl<IndependentWorkForm> implements IndependentWorkFormService {

    @Autowired
    public IndependentWorkFormServiceImpl(IndependentWorkFormRepository repository) {
        this.repository = repository;
    }
}
