package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.LaboratoryWork;
import com.bntu.fitr.poit.zholudev.diplom.repository.LaboratoryWorkRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.LaboratoryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.LABORATORY_WORK_NAME)
public class LaboratoryWorkServiceImpl extends EntityServiceImpl<LaboratoryWork, LaboratoryWorkRepository>
        implements LaboratoryWorkService {

    @Autowired
    public LaboratoryWorkServiceImpl(LaboratoryWorkRepository repository) {
        this.repository = repository;
    }
}
