package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Standard;
import com.bntu.fitr.poit.zholudev.diplom.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.STANDARD_NAME)
public class StandardServiceImpl extends EntityServiceImpl<Standard>{

    @Autowired
    public StandardServiceImpl(StandardRepository repository) {
        this.repository = repository;
    }
}
