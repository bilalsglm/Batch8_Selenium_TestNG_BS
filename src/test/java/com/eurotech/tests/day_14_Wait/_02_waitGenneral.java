package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_waitGenneral {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();//Coklu windows yapilarda tum sayfalari kapatmak icin QUIT methodu kullandik
    }

    @Test
    public void testwait() {
        //Wait bir senkronizasyon olarak da ifade edilir.

        //DOM --> HTML kodlarinin Dokument Object Model olarak ifede eder

        //Wait de bu DOM senkron bir sekilde calismasini saglar

        //Wait selenium kutuphanesine aittir. senkronizasyonu saglamak icin kullanilir


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        //checkbox in etken olmadigini dogrulayin
        checkbox.click();

        Assert.assertTrue(checkbox.isEnabled());

//        WebElement message = driver.findElement(By.id("message"));
//
//        Assert.assertTrue(message.isEnabled());


    }
}
