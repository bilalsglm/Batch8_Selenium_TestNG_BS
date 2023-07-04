package com.eurotech.tests.day_10_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_DisableElements {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void disableElements() throws InterruptedException {
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * locate disable text bar
         * verify that the element is disabled
         * locate and click the Enable button
         * send "The element is now enabled!!" keys to the bar
         * verify that the element is enabled.
         */


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement texBar = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(texBar.isEnabled());
        Thread.sleep(2000);

        WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableBtn.click();
        Thread.sleep(5000);

       // String s= "The element is now enabled!!";
        //texBar.sendKeys(s);
        texBar.sendKeys("The element is now enabled!!");
        Assert.assertTrue(texBar.isEnabled());


    }

    @Test
    public void disableElements_Task() throws InterruptedException {

        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displayed
         */

        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        Thread.sleep(2000);
        //locate pumpkin element
        WebElement pumpkinRadioBtn = driver.findElement(By.cssSelector("[value='pumpkin']"));



        // verify that the element is enabled
        // verify that the element is selected
        // verify that the element is displayed
        Assert.assertTrue(pumpkinRadioBtn.isEnabled());
        Assert.assertTrue(pumpkinRadioBtn.isSelected());
        Assert.assertTrue(pumpkinRadioBtn.isDisplayed());

        Thread.sleep(2000);

        //locate cabbage element
        WebElement cabbageRadioBtn = driver.findElement(By.cssSelector("[value='cabbage']"));

        // verify that the element is NOT enabled
        // verify that the element is NOT selected
        // verify that the element is displayed
        Assert.assertFalse(cabbageRadioBtn.isEnabled());
        Assert.assertFalse(cabbageRadioBtn.isSelected());
        Assert.assertTrue(cabbageRadioBtn.isDisplayed());
        Thread.sleep(2000);
    }
}
