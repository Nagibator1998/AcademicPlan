package com.bntu.fitr.poit.zholudev.diplom.repository;

import com.bntu.fitr.poit.zholudev.diplom.entity.Literature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends CrudRepository<Literature, Long> {
}
