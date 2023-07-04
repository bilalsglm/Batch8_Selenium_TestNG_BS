package com.eurotech.tests.day_6_7_xPath_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_RelativXPath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * task
         * navigate to https://demoqa.com/automation-practice-form
         * locate first name input box with xPath (parent-child relations)
         * send "Ayşegül" to the input box
         * locate sports checkbox with xPath (parent-child relations)
         * click to the checkbox
         * locate Student Registration Form element by xPath (parent-child relations)
         * get the text of web element and print it
         * close the driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        WebElement nameBox = driver.findElement(By.xpath("(//h5[contains(.,'Form')]/following-sibling::form//input)[1]"));
        nameBox.sendKeys("Aysegul");
        Thread.sleep(2000);

        WebElement cekBox = driver.findElement(By.xpath("//label[text()='Name']/ancestor::form//input[@id='hobbies-checkbox-1']/.."));
        cekBox.click();

        Thread.sleep(2000);
        WebElement aaaa = driver.findElement(By.xpath("//input[@id='lastName']/ancestor::form/preceding-sibling::h5"));
        String formtext= aaaa.getText();
        System.out.println("formtext = " + formtext);

        Thread.sleep(2000);

        driver.close();


    }
}
