package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_ByPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Sign Up button web element by using partial link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        //partial link text ile locate edelim
        WebElement signUpBtn = driver.findElement(By.partialLinkText("n Up"));
        String signUpBtnText = signUpBtn.getText();
        System.out.println("signUpBtnText = " + signUpBtnText);
        Thread.sleep(2000);

        System.out.println("signUpBtn.getAttribute(\"href\") = " + signUpBtn.getAttribute("href"));


        signUpBtn.click();
        Thread.sleep(2000);



        driver.close();


    }
}
/**
 * 1- a tag'ı ve href attribute'u olan web elementlerde kullanılır...
 * 2- <a class="btn btn-light" href="https://www.uzunihsan.com/login">ABCDEF</a> --> web elementinde ABCDEF link text kısmıdır..
 * bu text'in unique (eşsiz) olan bir bölümü alınarak kulllanılır.. mesela DEF kısmı olabilir... yazının sırası bozulmamalıdır.
 * 3- text kısmının bir bölümü alınmalıdır..
 */