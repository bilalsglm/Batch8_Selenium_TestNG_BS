package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_Css_AttributeValue_MultiplrAttributeValue {
    public static void main(String[] args) throws InterruptedException {

        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with one css attribute value
         * take DevEx text and print with css multiple attribute value (and)
         * take main text and print with css multiple attribute value (or)
         * close driver
         * --------------------
         * [attribute='value']
         * tagName[attribute='value']
         * ----------------------
         * birden çok attribute ile css'de locate etme:
         * [attribute1='value1'][attribute2='value2'] (and)
         * tagName[attribute1='value1'][attribute2='value2'] (and)
         *
         * [attribute1='value1'],[attribute2='value2'] (or)
         * tagName[attribute1='value1'],[attribute2='value2'] (or)
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //click cookies button with one css attribute value
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();
        Thread.sleep(2000);

        //take DevEx text and print with css multiple attribute value (and)
        WebElement devEx = driver.findElement(By.cssSelector("[class=\"x-large\"][id=\"landingpage-innercontainer-h1\"]"));
        System.out.println("devEx.getText() = " + devEx.getText());

        //take main text and print with css multiple attribute value (or)
        WebElement mainText = driver.findElement(By.cssSelector("[class=\"lead\"],[id=\"landingpage-innercontainer-p\"]"));
        System.out.println("mainText.getText() = " + mainText.getText());

        driver.close();
    }
}
