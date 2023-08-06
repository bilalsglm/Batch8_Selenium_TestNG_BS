package com.eurotech.tests.day_23_DDF;

import com.eurotech.pages.AddEducationPage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _5_DDF_AddEducationTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddEducationPage addEducationPage;
    @DataProvider
    public Object[][]userDate(){
        ExcelUtil qaTeam3=new ExcelUtil(ConfigurationReader.get("excelPath"),"QaTeam3");
        String[][] data = qaTeam3.getDataArrayWithoutFirstRow();
        return data;
    }
    @Test(dataProvider = "userDate")
    public void addEducationTestWithDDF(String yourEmail,String password,String fullName,String schoolName
            ,String degree,String study,String fromDate,String toDate,String programDescription){
        extentLogger=report.createTest("TC_0008 Add New "+fullName+"`s Education Test");

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();


        extentLogger.info("navigate to"+ConfigurationReader.get("url"));
        extentLogger.info("Enter site with correct userEmail and password");

        loginPage.login(yourEmail,password);

        extentLogger.info("Assert successful login with user name");
        String actualUserName=dashboardPage.userName.getText();
        Assert.assertEquals(actualUserName,fullName);

        extentLogger.info("Navigate to My Profile page");
        dashboardPage.navigateToTabsAndModule(fullName,"My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());

        extentLogger.info("Navigate to Add Education tab");
        userProfilePage.navigateUserProfileTabs("Add Education");

        extentLogger.info("Verify that add education page is displayed");
        Assert.assertTrue(BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5).isDisplayed());


        extentLogger.info("Fill the education form");
        addEducationPage.fillingAddEducationForm(schoolName,degree,study,fromDate,toDate,programDescription);

        extentLogger.info("Verify that added education record can be seen at user profile page");
        String actualSchoolName = userProfilePage.addedEdicutionName(schoolName);
        Assert.assertEquals(actualSchoolName,schoolName);


        extentLogger.info("Delete last added education record");
        userProfilePage.deleteEducationLastRecord(schoolName);

        extentLogger.pass("Passed.");
    }
}
