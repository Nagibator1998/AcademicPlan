package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.constatnts.EntityConstants;
import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import com.bntu.fitr.poit.zholudev.diplom.entity.Subject;
import com.bntu.fitr.poit.zholudev.diplom.report.configuration.DocxFileHandler;
import com.bntu.fitr.poit.zholudev.diplom.report.manager.impl.AcademicPlanReportManager;
import com.bntu.fitr.poit.zholudev.diplom.service.ExplanatoryNoteService;
import com.bntu.fitr.poit.zholudev.diplom.service.ReportService;
import com.bntu.fitr.poit.zholudev.diplom.service.UniversityService;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    @Qualifier(EntityConstants.UNIVERSITY_NAME)
    private UniversityService universityService;

    @Override
    public void makeReport(ExplanatoryNote explanatoryNote) throws Exception {

        FileInputStream fis = new FileInputStream(new File("qwe.docx"));
        new DocxFileHandler(fis, new AcademicPlanReportManager(explanatoryNote)).handle();


    }

}
