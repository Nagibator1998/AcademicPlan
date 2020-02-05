package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Section;
import com.bntu.fitr.poit.zholudev.diplom.repository.SectionRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.SECTION_NAME)
public class SectionServiceImpl extends EntityServiceImpl<Section> implements SectionService {

    @Autowired
    public SectionServiceImpl(SectionRepository repository) {
        this.repository = repository;
    }
}
