package com.bntu.fitr.poit.zholudev.diplom.repository;

import com.bntu.fitr.poit.zholudev.diplom.entity.LaboratoryWork;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryWorkRepository extends CrudRepository<LaboratoryWork, Long> {
}
