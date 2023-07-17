package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _5_AddExperience_Task extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    UserProfilePage userProfilePage;

    AddExperiencePage addExperiencePage;

    @Test
    public void addExperience(){

        /**
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with parameterized/non-parameterized method
         4-Assert successful login with user name
         5-Navigate to My Profile with related method
         6-Verify that User Profile page is displayed
         7-Navigate to Add Experience tab with related method
         8-Verify that add experience page is displayed
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added experience record can be seen at user profile page... (assert with job name)
         11-Delete last added experience record
         */

        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        userProfilePage=new UserProfilePage();
        addExperiencePage=new AddExperiencePage();

        loginPage.login();

        String actualUserName=dashboardPage.userName.getText();
        String expectedUserName= ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName);

        dashboardPage.navigateToTabsAndModule(ConfigurationReader.get("userName"),"My Profile");

        Assert.assertTrue(userProfilePage.userProfilePageTitle.isDisplayed());

        userProfilePage.navigateUserProfileTabs("Add Experience");

        Assert.assertTrue(BrowserUtils.waitForVisibility(addExperiencePage.addExperienceBtn,5).isDisplayed());

        addExperiencePage.fillingAddExperienceForm();

        String actualJobName = userProfilePage.addedExperienceName("QA");
        String expectedJobName="QA";

        Assert.assertEquals(actualJobName,expectedJobName);
        //Assert.assertFalse(actualJobName.contains(expectedJobName));

        userProfilePage.deleteExperienceLastRecord("QA");

    }

}
