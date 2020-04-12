package com.bntu.fitr.poit.zholudev.diplom.repository;

import com.bntu.fitr.poit.zholudev.diplom.entity.Competence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CompetenceRepository extends CrudRepository<Competence, Long> {

    @Query(value = "select distinct c.* from competences c, active_specialities a where a.explanatory_note_id = :explanatoryNoteId " +
            "and (a.speciality_id = c.speciality_id or c.speciality_id is NULL)", nativeQuery = true)
    Collection<Competence> getCompetencesForExplanatoryNote(@Param(value = "explanatoryNoteId") Long explanatoryNoteId);
}
