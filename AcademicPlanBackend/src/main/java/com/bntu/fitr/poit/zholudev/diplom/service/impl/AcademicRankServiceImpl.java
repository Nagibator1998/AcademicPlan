package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.AcademicRank;
import com.bntu.fitr.poit.zholudev.diplom.repository.AcademicRankRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.AcademicRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.ACADEMIC_RANK_NAME)
public class AcademicRankServiceImpl extends EntityServiceImpl<AcademicRank, AcademicRankRepository>
        implements AcademicRankService {

    @Autowired
    public AcademicRankServiceImpl(AcademicRankRepository repository) {
        this.repository = repository;
    }
}
