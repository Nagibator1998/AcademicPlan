package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Position;
import com.bntu.fitr.poit.zholudev.diplom.repository.PositionRepository;
import com.bntu.fitr.poit.zholudev.diplom.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.POSITION_NAME)
public class PositionServiceImpl extends EntityServiceImpl<Position, PositionRepository>
        implements PositionService {

    @Autowired
    public PositionServiceImpl(PositionRepository repository) {
        this.repository = repository;
    }
}
