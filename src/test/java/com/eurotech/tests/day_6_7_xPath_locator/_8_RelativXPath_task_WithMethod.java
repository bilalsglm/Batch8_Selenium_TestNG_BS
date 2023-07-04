package com.eurotech.tests.day_6_7_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class _8_RelativXPath_task_WithMethod {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * then click to the button
         * close driver
         */

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(3000);


        List<String> productNames = new ArrayList<>();
        productNames.add("$25 Virtual Gift Card");
        productNames.add("Build your own cheap computer");
        productNames.add("Build your own computer");
        productNames.add("Build your own expensive computer");
        productNames.add("Simple Computer");



        for (String productName:productNames) {
            addToCart(productName);
            Thread.sleep(2000);

        }


        driver.close();

    }

    public static void addToCart(String productName) throws InterruptedException {
        //driver.findElement(By.xpath("//a[text()='Simple Computer']//../following-sibling::div[3]//div[2]/input")).click();
        driver.findElement(By.xpath("//a[text()='"+productName+"']/../following-sibling::div[@*='add-info']//input")).click();
        Thread.sleep(2000);
        driver.navigate().back();


    }
}
