package com.gelin.excel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author green
 * @date 2018/6/22/022
 */
public class ImportExcel {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\初始数据文本\\输气处20180622导出.xlsx");
        InputStream inputStream = new  FileInputStream(file);
        List<String> list = new LinkedList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();

        for (int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            //用户名
            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            if (row.getCell(2).getStringCellValue() != null && !row.getCell(2).getStringCellValue().equals("")) {
                list.add(row.getCell(2).getStringCellValue());
            }
        }
        //这里只是打印给你看看
        list.stream()
            .limit(10)
            .forEach(System.out::println);
    }
}
