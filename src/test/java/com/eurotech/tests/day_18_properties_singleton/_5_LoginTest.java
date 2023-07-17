package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _5_LoginTest extends TestBase {
//    WebDriver driver;
//    @BeforeMethod
//    public void setUp(){
//        driver = Driver.get();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get(ConfigurationReader.get("url"));
//    }

    @Test
    public void loginTest(){
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys(ConfigurationReader.get("userEmail"));

        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        passwordBox.sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);
    }
//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }
}
