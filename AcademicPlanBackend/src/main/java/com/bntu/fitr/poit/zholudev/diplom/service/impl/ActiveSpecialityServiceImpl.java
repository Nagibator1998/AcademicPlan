package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ActiveSpeciality;
import com.bntu.fitr.poit.zholudev.diplom.repository.ActiveSpecialityRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.ActiveSpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.ACTIVE_SPECIALITY_NAME)
public class ActiveSpecialityServiceImpl extends EntityServiceImpl<ActiveSpeciality, ActiveSpecialityRepository>
        implements ActiveSpecialityService {

    @Autowired
    public ActiveSpecialityServiceImpl(ActiveSpecialityRepository repository) {
        this.repository = repository;
    }
}
