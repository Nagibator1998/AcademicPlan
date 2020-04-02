package com.bntu.fitr.poit.zholudev.diplom.controller;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.service.ExplanatoryNoteService;
import com.bntu.fitr.poit.zholudev.diplom.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Qualifier(EntityConstants.EXPLANATORY_NOTE_NAME)
    @Autowired
    private ExplanatoryNoteService explanatoryNoteService;

    @RequestMapping(value = "/{explanatoryNoteId}", method = RequestMethod.GET)
    public ResponseEntity getReport(@PathVariable(name = "explanatoryNoteId") Long explanatoryNoteId) throws Exception{
        this.reportService.makeReport(this.explanatoryNoteService.getById(explanatoryNoteId));
        return ResponseEntity.ok().body("");
    }
}
