package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.bind.annotation.XmlType;

public class _4_Css_IndexAndFollowingSibling {
    public static void main(String[] args) throws InterruptedException {

        /**
         * navigate to https://demoqa.com/automation-practice-form
         * send "hasan@hasan.com" to email box with css index
         * send "Bağcılar/İstanbul" to current address box with css sibling
         * close driver
         * --------------
         * cssSyntax--->tagName :nth-of-type(indexNumber)
         * cssSyntax--->tagName :nth-child(indexNumber)
         * NOTE: sadece aynı parent altındaki web elementlerde kullanılır..
         *
         * cssSyntax:tagName[]~tagName[]
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        //send "hasan@hasan.com" to email box with css index
        WebElement emailBox = driver.findElement(By.cssSelector("#userEmail-wrapper>div:nth-child(2)>input"));
        emailBox.sendKeys("hasan@hasan.com");
        Thread.sleep(2000);

        //send "Bağcılar/İstanbul" to current address box with css sibling
        WebElement addressInput = driver.findElement(By.cssSelector("form div~#currentAddress-wrapper>div~div>textarea"));
        addressInput.sendKeys("Bağcılar/İstanbul");
        Thread.sleep(2000);
        driver.close();

    }
}
