package com.eurotech.tests.day_22_xml_runner;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class _1_VerifyUserInfo extends TestBase {



        /** Class Task
         Login as a Mike
         userEmail=mike@gmail.com
         userPassword=mike1234
         Verify that login is successful
         Click on My profile
         Click on Edit Profile
         Verify that job is SDET
        */

        LoginPage loginPage;
        DashboardPage dashboardPage;
        UserProfilePage userProfilePage;
        EditProfilPage editProfilPage;
    @Test
    public void TC001(){
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        editProfilPage=new EditProfilPage();

        extentLogger=report.createTest("TC001");

        extentLogger.info("Login as a Mike");

        loginPage.login("mike@gmail.com","mike1234");

        extentLogger.info("Verify that login is successful");
        String expected ="mike";
        String actual=dashboardPage.userName.getText();
        Assert.assertEquals(actual,expected);

        extentLogger.info("Click on My profile");
        loginPage.navigateToTabsAndModule("mike","My Profile");

        extentLogger.info("Click on Edit Profile");
        userProfilePage.navigateUserProfileTabs("Edit Profile");

        extentLogger.info("Verify that job is SDET");
        String expected1="SDET";
        String actual1=editProfilPage.getSelected();
        Assert.assertEquals(actual1,expected1);

        extentLogger.pass("Passed");

    }

}
