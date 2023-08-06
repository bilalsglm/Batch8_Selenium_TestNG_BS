package com.eurotech.tests.day_23_DDF;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _1_ExcelDemo {

    public String readFromExcelCell(String path,String sheetName,int row,int columm) throws IOException {

        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        String cellValue = sheet.getRow(row).getCell(columm).getStringCellValue();
        return cellValue;

    }
    @Test
    public void Test1() throws IOException {
        String cell = readFromExcelCell("src/test/resources/LoginList.xlsx", "Test", 3, 1);
        System.out.println("cell = " + cell);
    }
}
