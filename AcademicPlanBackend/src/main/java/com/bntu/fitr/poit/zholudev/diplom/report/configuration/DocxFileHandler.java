package com.bntu.fitr.poit.zholudev.diplom.report.configuration;

import com.bntu.fitr.poit.zholudev.diplom.report.manager.ReportManager;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlCursor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<XmlCursor, Method> methodsToExecute = new HashMap<>();
        for (XWPFParagraph paragraph : paragraphs) {
            List<XWPFRun> runs = paragraph.getRuns();
            if (runs.isEmpty()) {
                continue;
            }
            Method method = getMethodToExecute(paragraph);
            if (method != null) {
                for (int i = runs.size() - 1; i >= 0; i--) {
                    paragraph.removeRun(i);
                }
                methodsToExecute.put(paragraph.getCTP().newCursor(), method);
            }
        }

        for(Map.Entry<XmlCursor, Method> entry: methodsToExecute.entrySet()){
            entry.getValue().invoke(this.reportManager, entry.getKey(), document);
        }

        FileOutputStream outputStream = new FileOutputStream(reportManager.getFileName() + ".docx");
        document.write(outputStream);
        outputStream.close();
    }

    private Method getMethodToExecute(XWPFParagraph paragraph) throws Exception {
        String text = paragraph.getText();

        if (text.contains(START_OF_METHOD) && text.contains(END_OF_METHOD)) {
            String methodName = text.substring(text.indexOf(START_OF_METHOD) + START_OF_METHOD.length(),
                    text.indexOf(END_OF_METHOD));

            if (isMethodExists(methodName)) {
                Method method = this.reportManager.getClass().getDeclaredMethod(methodName, XmlCursor.class, XWPFDocument.class);
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    private boolean isMethodExists(String methodName) {
        Class clazz = this.reportManager.getClass();
        boolean isMethodExists = false;
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(methodName) && method.getParameterCount() == 2) {
                isMethodExists = true;
                break;
            }
        }
        return isMethodExists;
    }
}
