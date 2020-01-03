package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Speciality;
import com.bntu.fitr.poit.zholudev.diplom.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.SPECIALITY_NAME)
public class SpecialityServiceImpl extends EntityServiceImpl<Speciality> {
    @Autowired

    public SpecialityServiceImpl(SpecialityRepository repository) {
        this.repository = repository;
    }
}
