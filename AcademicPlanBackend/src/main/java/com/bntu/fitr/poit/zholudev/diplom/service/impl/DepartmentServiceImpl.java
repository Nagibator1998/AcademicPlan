package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Department;
import com.bntu.fitr.poit.zholudev.diplom.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(EntityConstants.DEPARTMENT_NAME)
public class DepartmentServiceImpl extends EntityServiceImpl<Department> {
    @Autowired

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }
}
