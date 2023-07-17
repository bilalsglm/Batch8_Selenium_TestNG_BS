package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _7_RelativXPath_task {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * then click to the button
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(3000);

       // driver.findElement(By.xpath("//a[text()='Simple Computer']/../following-sibling::div[@*='add-info']//input")).click();
        driver.findElement(By.xpath("//a[text()='Simple Computer']/ancestor::*[@class='details']//input")).click();
        Thread.sleep(2000);


        driver.close();


    }
}
