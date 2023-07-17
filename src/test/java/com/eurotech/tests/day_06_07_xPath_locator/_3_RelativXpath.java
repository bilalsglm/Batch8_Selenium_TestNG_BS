package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_RelativXpath {
    public static void main(String[] args) throws InterruptedException {


        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath)
         * locate login button (use xPath)
         * click login button
         * locate email address input box (use xPath)
         * send "abc@abc.com" into email address input box
         * locate second login button (use xPath)
         * click Login button
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.get("http://www.eurotech.study/");

        // xpath ile contains metodu (text ile) --accept cookies
        driver.findElement(By.xpath("//button[contains(text(),'understand')]")).click();
        Thread.sleep(2000);

        //click login ---xpath bilinen attribute değeri ile
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginBtn.click();
        Thread.sleep(2000);

        //send keys to email --- xpath attribute starts-with metodu ile
        WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-i')]"));
        emailInputBox.sendKeys("abc@abc.com");
        Thread.sleep(2000);

        //e mail kismina yanlis yazip o yaziyi alabilme ...
//        System.out.println("emailInputBox.getAttribute(\"value\") = " + emailInputBox.getAttribute("value"));
//        System.out.println("emailInputBox.getAttribute(\"validationMessage\") = " + emailInputBox.getAttribute("validationMessage"));

        //click second login button--- xpath * kullanılarak..
        WebElement secondLoginBtn = driver.findElement(By.xpath("//*[@id='loginpage-form-btn']"));
        secondLoginBtn.click();
        Thread.sleep(2000);



        driver.close();

    }
}
