package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import com.bntu.fitr.poit.zholudev.diplom.report.configuration.DocxFileHandler;
import com.bntu.fitr.poit.zholudev.diplom.report.manager.ReportManager;
import com.bntu.fitr.poit.zholudev.diplom.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    @Qualifier("academicPlanReportManager")
    private ReportManager reportManager;

    @Override
    public void makeReport(ExplanatoryNote explanatoryNote) throws Exception {
        FileInputStream fis = new FileInputStream(new File("qwe.docx"));
        reportManager.setExplanatoryNote(explanatoryNote);
        new DocxFileHandler(fis, reportManager).handle();
        fis.close();
    }

}
