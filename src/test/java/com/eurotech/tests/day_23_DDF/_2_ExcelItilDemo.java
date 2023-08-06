package com.eurotech.tests.day_23_DDF;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _2_ExcelItilDemo {

    @Test
    public void readExcelFile(){

        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelDate = new ExcelUtil("src/test/resources/LoginList.xlsx", "Test");

        System.out.println("excelDate.rowCount() = " + excelDate.rowCount());

    }

    @Test
    public void readExcelFile_2(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelDate=new ExcelUtil(ConfigurationReader.get("excelPath"),"Test");

        //get columm caunt
        System.out.println("excelDate.columnCount() = " + excelDate.columnCount());
        System.out.println("---------------------------------------------");

        //get columm names
        System.out.println("excelDate.getColumnsNames() = " + excelDate.getColumnsNames());
        System.out.println("---------------------------------------------");

        //get all date to an array with columm names
        String[][] dataArray = excelDate.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        System.out.println("---------------------------------------------");

        System.out.println("dataArray[3][2] = " + dataArray[3][2]);

        System.out.println("---------------------------------------------");
        //get all date to an array without columm names
        String[][] dataArrayWithoutFirstRow = excelDate.getDataArrayWithoutFirstRow();
        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));

        System.out.println("---------------------------------------------");

        System.out.println("dataArrayWithoutFirstRow[3][2] = " + dataArrayWithoutFirstRow[3][2]);
        System.out.println("---------------------------------------------");

        //get all date to a list of map
        List<Map<String, String>> dataList = excelDate.getDataList();

        System.out.println("dataList = " + dataList);
        System.out.println("---------------------------------------------");
        System.out.println("dataList.get(0) = " + dataList.get(0));

        System.out.println("---------------------------------------------");

        System.out.println("dataList.get(4).get(\"Company\") = " + dataList.get(4).get("Company"));

        System.out.println("---------------------------------------------");

        System.out.println("dataList.get(9).get(\"City\") = " + dataList.get(9).get("City"));

    }
}
