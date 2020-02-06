package com.bntu.fitr.poit.zholudev.diplom.repository;

import com.bntu.fitr.poit.zholudev.diplom.entity.StudentMust;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMustRepository extends CrudRepository<StudentMust, Long> {
}
