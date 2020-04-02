package com.bntu.fitr.poit.zholudev.diplom.repository;

import com.bntu.fitr.poit.zholudev.diplom.entity.Competence;
import com.bntu.fitr.poit.zholudev.diplom.entity.University;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UniversityRepository extends CrudRepository<University, Long> {

    @Query(value = "select un.* from universities un, faculties fac, departments dep, specialities spec where " +
            "spec.id = :specialityId " +
            "and spec.department_id = dep.id " +
            "and dep.faculty_id = fac.id " +
            "and fac.university_id = un.id", nativeQuery = true)
    University getUniversityBySpecialityId(@Param(value = "specialityId") Long specialityId);
}
