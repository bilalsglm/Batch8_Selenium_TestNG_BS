package com.eurotech.tests.day_14_Wait;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class _03_implicitlyWait {

    //Bir kere yazilan ve genellikle Befor method icerisinde

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //Selenium 4 ile gelistirilmis hali
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void testimplicitly() {

        //Burda 15 saniye icerisinde bittiginde geri kalani kullanmadan jareket etmeyi saglar

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.xpath("//button[text()='Remove']"));
        //checkbox in etken olmadigini dogrulayin
        checkbox.click();


        WebElement message = driver.findElement(By.id("message"));

        Assert.assertTrue(message.isEnabled());

    }
    @Test
    public void implicitly(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.xpath("//button[text()='Remove']"));
        checkbox.click();


    }

}
