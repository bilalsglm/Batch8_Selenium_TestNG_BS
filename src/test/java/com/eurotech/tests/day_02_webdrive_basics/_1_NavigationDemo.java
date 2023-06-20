package com.eurotech.tests.day_02_webdrive_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);

        //navigate to another web page
        driver.navigate().to("https://testrelic.com/");
        Thread.sleep(2000);

        //navigate back -- sayfayı geri götürür
        driver.navigate().back();
        Thread.sleep(2000);

        //navigate forward -- sayfayı tekrar ileri götürür
        driver.navigate().forward();
        Thread.sleep(2000);

        //refresh page  -- sayfayı yeniler
        driver.navigate().refresh();
        Thread.sleep(2000);

        //driver.close();



    }
}
