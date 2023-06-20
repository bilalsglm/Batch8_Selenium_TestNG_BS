package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_GetAttribute_Practice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * take the value of the attributes (class and href) of the login button and print the values.
         * click login button
         * send "sdfsdsd" into email address input box
         * click Login button
         * get the message which appears on the email input box
         * VERIFY that the message contains "Please include an '@' in the email address."
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(3000);

        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement firstLoginBtn= driver.findElement(By.xpath("//a[@class=\"btn btn-light\"]"));
        System.out.println("firstLoginBtn.getAttribute(\"class\") = " + firstLoginBtn.getAttribute("class"));
        System.out.println("firstLoginBtn.getAttribute(\"href\") = " + firstLoginBtn.getAttribute("href"));

        firstLoginBtn.click();
        Thread.sleep(3000);

        WebElement emailInputBox= driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys("sdfsdsd");

        WebElement secondLoginBtn = driver.findElement(By.id("loginpage-form-btn"));
        secondLoginBtn.click();
        Thread.sleep(3000);

        String actualMassage= emailInputBox.getAttribute("validationMessage");
        String expectedMessage= "Please include an '@' in the email address.";

        if (actualMassage.contains(expectedMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
