package com.eurotech.tests.day_06_07_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _9_ReletivXPath_Task_2 {

    public static void main(String[] args) throws InterruptedException {

        /**
         * open a chrome browser
         * navigate to http://opencart.abstracta.us/index.php?route=common/home
         * locate "iPhone Add to Cart Button" with the name of product iPhone
         * then click to the add to cart button
         * take the text of success message which appears after the click
         * verify that the message contains "Success"
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");

        //WebElement addCartBtn = driver.findElement(By.xpath("//a[text()='iPhone']/ancestor::div[@class='caption']/following-sibling::div/button[@onclick=\"cart.add('40');\"]"));
        WebElement addCartBtn = driver.findElement(By.xpath("//a[text()='iPhone']/ancestor::div[@class='caption']/following-sibling::div/button[1]"));
        addCartBtn.click();
        Thread.sleep(3000);

        WebElement successMsg = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
        String actualMessag = successMsg.getText();
        System.out.println(actualMessag);
        String expectedMessag = "Success: You have added iPhone to your shopping cart!\n" + "×";

        Thread.sleep(3000);

        if (actualMessag.equals(expectedMessag)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }

        driver.close();
    }
}

