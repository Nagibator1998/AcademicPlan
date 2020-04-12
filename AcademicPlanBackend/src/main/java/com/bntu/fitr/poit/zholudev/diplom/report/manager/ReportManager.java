package com.bntu.fitr.poit.zholudev.diplom.report.manager;

import com.bntu.fitr.poit.zholudev.diplom.entity.ExplanatoryNote;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public interface ReportManager {

    String getFileName();
    void setExplanatoryNote(ExplanatoryNote explanatoryNote);
}
