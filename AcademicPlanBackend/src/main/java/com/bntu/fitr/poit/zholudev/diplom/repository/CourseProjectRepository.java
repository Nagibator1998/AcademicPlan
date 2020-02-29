package com.bntu.fitr.poit.zholudev.diplom.repository;

import com.bntu.fitr.poit.zholudev.diplom.entity.CourseProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseProjectRepository extends CrudRepository<CourseProject, Long> {

    @Query(value = "select cp.* from course_projects cp, active_specialities acs where acs.explanatory_note_id = :explanatoryNoteId " +
            "and acs.course_project_id = cp.id", nativeQuery = true)
    CourseProject getByExplanatoryNoteId(@Param(value = "explanatoryNoteId") Long explanatoryNoteId);
}
