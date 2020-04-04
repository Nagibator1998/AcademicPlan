package com.bntu.fitr.poit.zholudev.diplom.report.configuration;

import com.bntu.fitr.poit.zholudev.diplom.report.manager.ReportManager;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.*;

public class DocxFileHandler {

    private static final String START_OF_METHOD = "#{";
    private static final String END_OF_METHOD = "}#";

    private FileInputStream file;
    private ReportManager reportManager;

    public DocxFileHandler(FileInputStream file, ReportManager reportManager) {
        this.file = file;
        this.reportManager = reportManager;
    }

    public void handle() throws Exception {
        XWPFDocument document = new XWPFDocument(this.file);
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            List<XWPFRun> runs = paragraph.getRuns();
            if (runs.isEmpty()) {
                continue;
            }
            String changedText = changedTextByExpression(paragraph);
            for (int i = runs.size() - 1; i > 0; i--) {
                paragraph.removeRun(i);
            }
            XWPFRun firstRun = runs.get(0);
            if(changedText.contains("\n")){
                String[] dividedByBreak = changedText.split("\n");
                firstRun.setText("", 0);
                for (String dividedString : dividedByBreak) {
                    firstRun.setText(dividedString);
                    firstRun.addCarriageReturn();
                }
            }
            else {
                firstRun.setText(changedText, 0);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(reportManager.getFileName() + ".docx");
        document.write(outputStream);
        outputStream.close();
    }

    private String changedTextByExpression(XWPFParagraph paragraph) throws Exception {
        String text = paragraph.getText();

        if (text.contains(START_OF_METHOD) && text.contains(END_OF_METHOD)) {
            String methodName = text.substring(text.indexOf(START_OF_METHOD) + START_OF_METHOD.length(),
                    text.indexOf(END_OF_METHOD));

            if (isMethodExists(methodName)) {
                Method method = this.reportManager.getClass().getDeclaredMethod(methodName);
                method.setAccessible(true);
                String insertString = (String) method.invoke(this.reportManager);
                text = text.replace(text.substring(text.indexOf(START_OF_METHOD),
                        text.indexOf(END_OF_METHOD) + END_OF_METHOD.length()), insertString);

            }
        }
        return text;
    }

    private boolean isMethodExists(String methodName) {
        Class clazz = this.reportManager.getClass();
        boolean isMethodExists = false;
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName)) {
                isMethodExists = true;
                break;
            }
        }
        return isMethodExists;
    }
}
