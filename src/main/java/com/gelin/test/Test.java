package com.gelin.test;


import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author green
 * @date 2018/5/11/011
 */
public class Test {
    public static void main(String[] args) throws IOException {
         File file=new File("C:\\Users\\Administrator\\Desktop\\2.xls");
        InputStream inputStream=FileUtils.openInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Map<Integer,Map<Integer,String>> value=new HashMap<>();
        Map a=new HashMap();
        a.put(12,"AAA");
        a.put(10,"BBB");
        Map a1=new HashMap();
        a1.put(4,"CCC");
        value.put(3,a);
        value.put(4,a1);


        value.forEach((k,v)->{
            HSSFRow row = sheet.getRow(k);
            v.forEach((k1,v1)->{
                row.getCell(k1).setCellValue(v1);
            });
        });
        OutputStream os = new FileOutputStream(new File("D:/1.xls"));
        workbook.write(os);
    }

}
