package com.eurotech.tests.day_15_actions_fileUpload_jsExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _2_JS_ExecutorDemo {

    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.close();
    }

    @Test
    public void clickWithJS() {

        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * click Almanya link with js executor
         * accept cookies if any
         * verify that the url contains amazon.de
         *
         * note : ask google how to click with js executor
         */


        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement almanya = driver.findElement(By.linkText("Almanya"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", almanya);

        driver.findElement(By.id("sp-cc-accept")).click();
        //almanya.click(); // bu da calsiyor

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("amazon.de"));


    }

    @Test
    public void typeWithJS() {

        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * send "Hello World!" to the disabled box with js executor
         *
         * note : ask google--> how to sendKeys using JSExecutor
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBox = driver.findElement(By.cssSelector("#input-example>input"));

        String text="Hello World!";

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //jse.executeScript("arguments[0].value='enter the value here';",textBox);
        jse.executeScript("arguments[0].value='"+text+"';", textBox);


    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {

        /**
         * go to https://www.amazon.com.tr/"
         *  accept cookies if any
         * make scroll down and up
         */

        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,4000)");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,500)");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-500)");
        }

    }

    @Test
    public void scrollToElement() {

        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * scroll to the Almanya and click it
         */

        driver.get("https://www.amazon.com.tr/");

        driver.findElement(By.id("sp-cc-accept")).click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement almanya = driver.findElement(By.linkText("Almanya"));
        //jse.executeScript("arguments[0].scrollIntoView(true);", almanya);

        jse.executeScript("arguments[0].scrollIntoView(true);" + "arguments[0].click()",almanya);

        driver.findElement(By.id("sp-cc-accept")).click();
        //almanya.click(); // bu da calsiyor

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("amazon.de"));

    }

    @Test
    public void jsExcutor_Task() throws InterruptedException {
        /**
         * navigate to https://www.krafttechexlab.com/forms/elements
         * scroll 1000 px down
         * change the Range position (actions ile)
         * change the Disabled Range position
         * scroll to the Number label
         * change the color from blue to red
         * select the Disabled Radio 3 button
         * scroll to the submit button
         * scroll again to the number label
         * scroll to the submit button and click on it
         * take the new page title and url
         * verify that the page title contains "Kraft"
         *
         * not: all steps should be done with js executor except step 3 and last one.
         */

        driver.get("https://www.krafttechexlab.com/forms/elements");

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(3000);

        WebElement rangeElement = driver.findElement(By.id("customRange1"));


        actions.dragAndDropBy(rangeElement,100,0).build().perform();

        WebElement disabledRange = driver.findElement(By.id("disabledRange"));

        jse.executeScript("arguments[0].value = '75';",disabledRange);

        WebElement numElement = driver.findElement(By.xpath("//label[text()='Number']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", numElement);

        WebElement exampleColorInput = driver.findElement(By.id("exampleColorInput"));
        jse.executeScript("arguments[0].setAttribute('value', '#FF0000')", exampleColorInput);

        WebElement gridRadios = driver.findElement(By.id("gridRadios"));
        jse.executeScript("arguments[0].click();", gridRadios);

        WebElement submitbtn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        jse.executeScript("arguments[0].scrollIntoView(true);", submitbtn);

        jse.executeScript("arguments[0].scrollIntoView(true);", numElement);

        jse.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click()", submitbtn);

        String title = jse.executeScript("return document.title;").toString();
        String url = jse.executeScript("return document.URL;").toString();

        System.out.println("title = " + title);
        System.out.println("url = " + url);

        Assert.assertTrue(driver.getTitle().contains("Kraft"));



    }
}
