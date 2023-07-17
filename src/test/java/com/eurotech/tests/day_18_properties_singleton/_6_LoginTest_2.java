package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _6_LoginTest_2 extends TestBase {

    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with url
     * https://www.krafttechexlab.com/index
     */
    @Test
    public void logintest_1(){

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.krafttechexlab.com/index";

        assertEquals(actualUrl,expectedUrl);
    }
    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with page title
     * https://www.krafttechexlab.com/index
     */

    @Test
    public void loginTest_2(){

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));

        WebElement loginBox = driver.findElement(By.xpath("//button[text()='Login']"));
        loginBox.click();

        String actualTitle = driver.getTitle();
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";

      assertEquals(actualTitle,expectedTitle);

    }

    /**
     * go to kraft login page
     * login with your credentials
     * validate that you are on the dashboard with page title
     * https://www.krafttechexlab.com/index
     */
    @Test
    public void userName(){

        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));

        WebElement loginBox = driver.findElement(By.xpath("//button[text()='Login']"));
        loginBox.click();

        WebElement UserName = driver.findElement(By.tagName("h2"));
        String actual= UserName.getText();
        String expected="bilal";

        assertEquals(actual,expected);

    }

}
