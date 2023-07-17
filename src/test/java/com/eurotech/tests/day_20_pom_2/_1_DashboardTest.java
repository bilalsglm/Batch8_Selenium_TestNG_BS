package com.eurotech.tests.day_20_pom_2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1_DashboardTest extends TestBase {

    @Test
    public void tabMenuTest(){

        /**
         * go to kraft login page
         * login with valid credentials
         * verify that you are on the dashboard page by using 'Dashboard' keyword at top-left
         * Verify that tabs menu contains "Dashboard", "Developers", "Components", "Forms",  "JavaScript", "Melih Gezer"
         */
        LoginPage loginPage=new LoginPage();

        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();

        String actualTitle = dashboardPage.dashboartPageTitle.getText();
        String expectegTitle="Dashboard";

        Assert.assertEquals(actualTitle,expectegTitle);

//        List<WebElement> tabMenu = dashboardPage.tabMenu;
//
//        List<String> tabMenuManes=new ArrayList<>();
//
//        for (WebElement menu : tabMenu) {
//            tabMenuManes.add(menu.getText());
//        }

        List<String> tabMenuManes=dashboardPage.getTabMenuNames();

        List<String> expectedTabNames=new ArrayList<>(Arrays.asList("Dashboard", "Developers", "Components", "Forms",  "JavaScript","bilal"));


        Assert.assertEquals(tabMenuManes,expectedTabNames);
    }

    @Test
    public void navigateMenu_1(){

        /**
         * login with valid credentials
         * go to 'Developers' tab via navigateToTabs()
         * validate that you are on the right page through url
         * expectedUrl = https://www.krafttechexlab.com/developers
         */

        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToTabsAndModule("Developers");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/developers";

        Assert.assertEquals(actualUrl,expectedUrl);

    }

    @Test
    public void navigateMenu_2(){

        /**
         * login with valid credentials
         * go to 'Components --> Modal' submodule via navigateToTabsAndModule( two parameters)
         * validate that you are on the right page through url
         * ExpectedUrl="https://www.krafttechexlab.com/components/modal"
         */

        LoginPage loginPage=new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToTabsAndModule("Components","Modal");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/components/modal";
        Assert.assertEquals(actualUrl,expectedUrl);

        dashboardPage.navigateToTabsAndModule("Developers");


        String actualUrl1=driver.getCurrentUrl();
        String expectedUrl1="https://www.krafttechexlab.com/developers";

        Assert.assertEquals(actualUrl1,expectedUrl1);
    }

}
