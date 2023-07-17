package com.eurotech.tests.day_12_alertAndMultipleWindowReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_HTML_Popups {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void htmlPopup() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show alert box
         * verify that ok button can be seen on the popup
         * take the text on popup and print it (I am a fake alert box!)
         * then click on ok at the popup
         * verify that ok button cannot be seen
         */


        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#fakealert")).click();
        Thread.sleep(2000);

        WebElement okBtn = driver.findElement(By.id("dialog-ok"));
        Assert.assertTrue(okBtn.isDisplayed());

        System.out.println(driver.findElement(By.id("dialog-text")).getText());

        okBtn.click();
        Thread.sleep(2000);

        Assert.assertFalse(okBtn.isDisplayed());


    }

    @Test
    public void htmlPopup_Task() throws InterruptedException {
        /**
         * go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
         * click on confirm button
         * click on yes at the popup window
         * make verification with confirmed popup
         */


        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        Thread.sleep(2000);

        WebElement confirmBtn = driver.findElement(By.id("j_idt343:j_idt344"));
        confirmBtn.click();
        Thread.sleep(2000);

        WebElement yesBtn = driver.findElement(By.id("j_idt343:j_idt348"));
        yesBtn.click();
        Thread.sleep(2000);

        WebElement result = driver.findElement(By.className("ui-growl-message"));
        System.out.println("result.getText() = " + result.getText());


    }
}
