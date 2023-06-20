package com.eurotech.tests.day_02_webdrive_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_CloseEndQuit {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.euroTechStudy.de");

        Thread.sleep(2000);

        //close driver with close() method
        // close current tab
        driver.close();


        WebDriverManager.chromiumdriver().setup();
        WebDriver driver1=new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.navigate().to("httbs://www.amazon.de");
        Thread.sleep(2000);

        //close all tabs
        driver1.quit();

        //kapanmış driverı açmak için tekrar assign etmek gerekir..
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.close();



    }
}
