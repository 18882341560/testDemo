package com.gelin.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test1 {

    public static void checkRowCell(XSSFCell cell,int i,int j) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                System.out.println(cell.getRichStringCellValue().getString() + "="+i+":"+j);
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.println(String.valueOf(cell.getDateCellValue()) + "="+i+":"+j);
                } else {
                    System.out.println(cell.getNumericCellValue() + "="+i+":"+j);
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.println(cell.getBooleanCellValue() + "="+i+":"+j);
                break;
            default:
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = "C:\\Users\\Administrator\\Desktop\\1.xlsx";
        File file = new File(filePath);
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowcount = sheet.getLastRowNum();

        for (int i = 0; i < rowcount + 1; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    XSSFCell cell = (XSSFCell) row.getCell(j);
                    if (cell != null) {
                        Test1.checkRowCell(cell,i,j);
                    }
                }
            }
        }

    }
}