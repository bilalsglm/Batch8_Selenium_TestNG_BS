package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.*;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_AddEducation_Task extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    UserProfilePage userProfilePage;
    AddEducationPage addEducationPage;


    @Test
    public void AddEducationTest(){

        /**
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with parameterized/non-parameterized method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method
         6-Verify that User Profile page is displayed
         7-Navigate to Add Education tab with related method
         8-Verify that add education page is displayed
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added education record can be seen at user profile page... (assert with school name)
         11-Delete last added education record

         important note: every student should use own credentials, otherwise the test case will fail....
         */


        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addEducationPage=new AddEducationPage();

        loginPage.login();

        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName);

        dashboardPage.navigateToTabsAndModule(ConfigurationReader.get("userName"),"My Profile");

        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());

        userProfilePage.navigateUserProfileTabs("Add Education");

        //Assert.assertTrue(new WebDriverWait(driver,5))

        Assert.assertTrue(BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5).isDisplayed());

        addEducationPage.fillingAddEducationForm("ITU","First","Engineering","10102017","08102022","Hard Program");

        String actualSchoolName = userProfilePage.addedEdicutionName("ITU");
        String expectedSchoolName="ITU";

        Assert.assertEquals(actualSchoolName,expectedSchoolName);

        userProfilePage.deleteEducationLastRecord("ITU");
    }
}
