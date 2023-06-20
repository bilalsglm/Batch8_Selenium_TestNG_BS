package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_DuplicateClassName {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to https://demoqa.com/text-box
         * locate Full Name label web element by using class name locator
         * get the text of web element and print it
         * close driver.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        Thread.sleep(2000);

        WebElement fulNameLabel = driver.findElement(By.className("form-label"));

        //textini alalım
        String fulNameLabelText = fulNameLabel.getText();

        System.out.println("fulNameLabelText = " + fulNameLabelText);

        Thread.sleep(2000);

        driver.close();

    }
}
