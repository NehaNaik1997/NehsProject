package com.actitime_automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;

public class ExcelFileExample1 {
    public static void main(String [] args)
    {
        try {
            String Filepath = "C:\\Users\\chait\\OneDrive\\Pictures\\Book1.xlsx";
            File file = new File(Filepath);
            FileInputStream fis1 = new FileInputStream(file);
            FileInputStream fis = new FileInputStream("C:\\Users\\chait\\OneDrive\\Pictures\\Book1.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Workbook wb1 = WorkbookFactory.create(fis1);
            int totalNoOfSheets = wb.getNumberOfSheets();
            System.out.println("Total Sheets : " + totalNoOfSheets);
            for (int i = 0; i < totalNoOfSheets; i++) {
                String sheetName = wb.getSheetName(i);
                System.out.println("sheet Name at " + i + " : " + sheetName);
            }
            int index = wb.getSheetIndex("OnlyStringTypes");
            System.out.println("Index: " + index);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
