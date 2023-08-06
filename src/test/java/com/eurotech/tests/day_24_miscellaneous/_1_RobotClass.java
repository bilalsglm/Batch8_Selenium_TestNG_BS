package com.eurotech.tests.day_24_miscellaneous;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _1_RobotClass {

    @Test
    public void robotClassBasicAuthentication() throws AWTException, InterruptedException {

        /**
         * navigate to https://the-internet.herokuapp.com/digest_auth
         * Type in username and password by using robot class
         * Click Sign in button
         *
         * Note: 1- use us Q keyboard
         *       2- username: admin and password:admin
         */

        WebDriver driver=Driver.get();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/digest_auth");

        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        String expectedText="Digest Auth";
        String actualText=driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actualText,expectedText);

        driver.quit();

    }

    @Test
    public void robotClassUsage() throws AWTException, InterruptedException {
        /**
         * navigate to kraft login page
         * Press tab with robot class
         * Type in user email and password by using robot class (email: Aadmın, password:admın)
         * Click Create an account link
         * Verify that create an account page is displayed

         */

        WebDriver driver=Driver.get();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));

        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_SHIFT);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        robot.keyPress(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

        String expectedText="Create an Account";
        String ectualeText=driver.findElement(By.tagName("h5")).getText();

        Assert.assertEquals(ectualeText,expectedText);

    }

    @Test
    public void robotClass() throws InterruptedException {

        WebDriver driver=Driver.get();
        driver.manage().window().maximize();
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");

        Thread.sleep(2000);


    }
}
