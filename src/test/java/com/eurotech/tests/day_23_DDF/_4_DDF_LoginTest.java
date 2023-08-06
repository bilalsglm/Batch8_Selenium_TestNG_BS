package com.eurotech.tests.day_23_DDF;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _4_DDF_LoginTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    @DataProvider
    public Object[][]userDate(){
        ExcelUtil qaTeam1=new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam1");
        String[][] dataArrayWithoutFirstRow = qaTeam1.getDataArrayWithoutFirstRow();
        return dataArrayWithoutFirstRow;
    }

    @Test(dataProvider = "userDate")
    public void loginTestWithDDF(String fullName,String yourEmail,String password){
        extentLogger=report.createTest("TC_005 "+fullName+"`s Login Test");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to Kraft Login Page");
        extentLogger.info("Login with valid creadentials");

        loginPage.login(yourEmail,password);
        extentLogger.info("Verify success login with username");

        String actualUsername = dashboardPage.userName.getText();
        Assert.assertEquals(actualUsername,fullName);

        extentLogger.pass("Passed..!");

    }
    @DataProvider
    public Object[][]userDate_1(){
        ExcelUtil qaTeam2=new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam2");
        String[][] dataArrayWithoutFirstRow = qaTeam2.getDataArrayWithoutFirstRow();
        return dataArrayWithoutFirstRow;
    }

    @Test(dataProvider = "userDate_1")
    public void loginTestWithDDF_1(String yourEmail,String password,String fullName){
        extentLogger=report.createTest("TC_005 "+fullName+"`s Login Test");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();

        extentLogger.info("navigate to Kraft Login Page");
        extentLogger.info("Login with valid creadentials");

        loginPage.login(yourEmail,password);
        extentLogger.info("Verify success login with username");

        String actualUsername = dashboardPage.userName.getText();
        Assert.assertEquals(actualUsername,fullName);

        extentLogger.pass("Passed..!");

    }
}
