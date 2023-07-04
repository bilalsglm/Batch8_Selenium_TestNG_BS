package com.eurotech.tests.day_13_MultipleNewWindow;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _01_multipleNewWindow {
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
    public void testMultipleNewWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        String parentWindow=driver.getWindowHandle();//Burada acilan pencerenin Hash kodunu aldik

        WebElement newWindow=driver.findElement(By.id("windowButton"));
        newWindow.click();

        Set<String> handles= driver.getWindowHandles();//Bu ayni zamanda Selenium ile gelen bir kuraldir.

        Thread.sleep(2000);

        for (String handle : handles) {
            System.out.println("handle = " + handle);//Burada Hash kodlari yer aliyor
            if (!handle.equals(parentWindow)){
                driver.switchTo().window(handle);//Burada yeni acilan windows sayfasina gectik
            }

        }

    }

    @Test
    public void testMultipleTabsOrWindowsWhichChoose() throws InterruptedException {
        //ikiden fazla yani coklu Tab veya Windows acildiginda hangisine nasil gidecegiz;

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        //Cookies accept
        Thread.sleep(3000);

        driver.getWindowHandle();

        driver.findElement(By.id("newTabBtn")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("newWindowsBtn")).click();

        Set<String> handles=driver.getWindowHandles();

        String expectedTitle="XPath Practice - H Y R Tutorials";

        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println("Current Windows Title:  " + driver.getTitle());
            if (driver.getTitle().equals(expectedTitle)){
                break;
            }
        }
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);//QA icin MUST

    }
}
