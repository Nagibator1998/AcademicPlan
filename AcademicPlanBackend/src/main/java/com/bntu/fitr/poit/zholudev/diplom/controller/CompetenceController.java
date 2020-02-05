package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.Competence;
import com.bntu.fitr.poit.zholudev.diplom.service.CompetenceCodeService;
import com.bntu.fitr.poit.zholudev.diplom.service.CompetenceService;
import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/" + EntityConstants.COMPETENCE_NAME)
public class CompetenceController extends EntityController<Competence, CompetenceService> {
    @Autowired
    public CompetenceController(CompetenceService service) {
        this.service = service;
    }

    @RequestMapping(value = EntityConstants.COMPETENCE_NAME + "/forExplanatoryNote/{explanatoryNoteId}",
            method = RequestMethod.GET)
    public ResponseEntity getCompetencesForExplanatoryNote(@PathVariable(name = "explanatoryNoteId") Long explanatoryNote) {
        return ResponseEntity.ok(this.service.getCompetencesForExplanatoryNote(explanatoryNote));
    }

}
