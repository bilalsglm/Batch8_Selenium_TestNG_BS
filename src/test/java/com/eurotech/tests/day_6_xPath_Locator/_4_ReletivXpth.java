package com.eurotech.tests.day_6_xPath_Locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _4_ReletivXpth {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with attribute feature)
         * locate Developers link (use xPath with text feature)
         * click the Developers link
         * locate Filter By element (use xPath with text feature)
         * get the text of element and print it
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'understand')]")).click();
        Thread.sleep(2000);
    }
}
