package com.eurotech.tests.day_19_pom_1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_TestWithListOfWebElemets extends TestBase {
    @Test
    public void positiveLoginTestWithListOfWebElemets(){

        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials (use list of element)
         * verify success login user's name (Melih Gezer)
         *
         */

        LoginPage loginPage=new LoginPage();
        loginPage.loginInputs.get(0).sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.loginInputs.get(1).sendKeys(ConfigurationReader.get("password"));
        loginPage.loginInputs.get(2).click();

        DashboardPage dashboardPage=new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName="bilal";

        Assert.assertEquals(actualUserName,expectedUserName);


    }
}
