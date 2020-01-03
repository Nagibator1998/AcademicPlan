package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveSpeciality;
import com.bntu.fitr.poit.zholudev.diplom.repository.ActiveSpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.ACTIVE_SPECIALITY_NAME)
public class ActiveSpecialityServiceImpl extends EntityServiceImpl<ActiveSpeciality> {

    @Autowired
    public ActiveSpecialityServiceImpl(ActiveSpecialityRepository repository) {
        this.repository = repository;
    }
}
