package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_EditProfileTest extends TestBase {

    @Test
    public void editProfileTest(){
        /**
         * Class Task
         * THIS TASK WILL BE IMPLEMENTED USING POM
         * which means we will have one test class for the test
         * and one corresponding page having all locators and actions for the page
         *
         * go to https://www.krafttechexlab.com/login
         * enter valid credentials (your credentials)
         * wait for usernames are displayed (both middle and right top)
         * go to Melih Gezer --> myProfile
         * wait for page title is displayed
         *** create a method that navigate you to specific module based on the given parameter
         * go to Edit Profile page using the method just mentioned above
         * fill out the fields
         * -->about --> SDET programme , graduated from KraftTech
         * -->Company --> Google
         * -->Job  --> QA Automation Engineer
         * -->Website --> www.google.com
         * -->Location --> Istanbul
         * -->Skills --> Java,Selenium, TestNG
         * click save changes button
         * verify that "Profile updated" message is appeared
         */
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        UserProfilePage userProfilePage=new UserProfilePage();
        EditProfilPage editProfilPage=new EditProfilPage();

        loginPage.login();


        BrowserUtils.waitForVisibility(dashboardPage.userName,5);

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.userNameAtRigt));

        dashboardPage.navigateToTabsAndModule("bilal","My Profile");

        BrowserUtils.waitForVisibility(userProfilePage.userProfilePageTitle,5);

        userProfilePage.navigateUserProfileTabs("Edit Profile");

        editProfilPage.aboutBox.clear();
        editProfilPage.aboutBox.sendKeys("SDET programme , graduated from KraftTech");

        editProfilPage.companyBox.clear();
        editProfilPage.companyBox.sendKeys("Google");

//        Select select=new Select(editProfilPage.jobSelect);
//        select.selectByVisibleText("QA Automation Engineer");

        editProfilPage.selectJob("Manual Tester");

        editProfilPage.websiteBox.clear();
        editProfilPage.websiteBox.sendKeys("www.google.com");

//        editProfilPage.locationBox.clear();
//        editProfilPage.locationBox.sendKeys("Istanbul");

       BrowserUtils.clearAndSendKeys(editProfilPage.locationBox, "Hannover");

        editProfilPage.skillsBox.clear();
        editProfilPage.skillsBox.sendKeys("Java,Selenium, TestNG");

        //editProfilPage.saveChangesBox.click();
        BrowserUtils.clickWithJS(editProfilPage.saveChangesBox);

        String actualMessage = userProfilePage.profileUptdaMasega.getText();
        String expectedMessage="Profile Updated";

        Assert.assertEquals(actualMessage,expectedMessage);


    }
}
