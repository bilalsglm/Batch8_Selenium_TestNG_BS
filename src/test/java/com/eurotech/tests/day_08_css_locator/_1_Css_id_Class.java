package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_Css_id_Class {
    public static void main(String[] args) throws InterruptedException {

        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with css id
         * click Sign Up button css class
         * send "Ahmet" to name box by css id with tag
         * click register button by css class with tag
         * close driver
         *--------------------
         * #id
         * tagName#id
         * -------------------
         * .className
         * tagName.className
         * Note: eğer class name'de boşluk varsa silinip yerine . (nokta) konulur.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //click cookies button with css id
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();
        Thread.sleep(2000);

        //click Sign Up button css class
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(2000);

        //send "Ahmet" to name box by css id with tag
        WebElement nameBox = driver.findElement(By.cssSelector("input#signuppage-form-name-input"));
        nameBox.sendKeys("Ahmet");
        Thread.sleep(2000);

        //click register button by css class with tag  //lazy way
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(2000);

        driver.close();

    }
}
