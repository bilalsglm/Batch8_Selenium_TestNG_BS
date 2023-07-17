package com.eurotech.tests.day_21_extent_report;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _4_AddExperiwnceTestWithExtentReport_Task extends TestBase {


    LoginPage loginPage;
    DashboardPage dashboardPage;

    UserProfilePage userProfilePage;

    AddExperiencePage addExperiencePage;

    @Test
    public void addExperience(){

        /**
         1-go to kraft login page
         2-make login
         3-Assert successful login with user name
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experince page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page... (assert with job title)
         10-Delete last added experience record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addExperiencePage=new AddExperiencePage();

        extentLogger=report.createTest("TC010 Add Experience Test");

        extentLogger.info("go to kraft login page");
        extentLogger.info("make login");
        loginPage.login();

        extentLogger.info("Assert successful login with user name");
        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,expectedUserName);

        extentLogger.info("Navigate to My Profile with related method");
        dashboardPage.navigateToTabsAndModule(ConfigurationReader.get("userName"),"My Profile");

        extentLogger.info("Verify that User Profile page is displayed");
        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());

        extentLogger.info("Navigate to Add Experience tab with related method");
        userProfilePage.navigateUserProfileTabs("Add Experience");

        extentLogger.info("Verify that add experince page is displayed");
        Assert.assertTrue(BrowserUtils.waitForVisibility(addExperiencePage.addExperienceBtn,5).isDisplayed());

        extentLogger.info("Fill the form with non-parameterized method");
        addExperiencePage.fillingAddExperienceForm();

        extentLogger.info("Verify that added experience record can be seen at user profile page");
        String actualJobName = userProfilePage.addedExperienceName("QA");
        String expectedJobName="QA";
        Assert.assertEquals(actualJobName,expectedJobName);

        extentLogger.info("Delete last added experience record");
        userProfilePage.deleteExperienceLastRecord("QA");

        extentLogger.pass("Passed");
    }
}
