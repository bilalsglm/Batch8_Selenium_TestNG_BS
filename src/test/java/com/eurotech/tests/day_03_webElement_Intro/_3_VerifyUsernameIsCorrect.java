package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_VerifyUsernameIsCorrect {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");

        Thread.sleep(3000);

        String username="test";

        WebElement userNameInputBox=driver.findElement(By.id("userName"));
        userNameInputBox.sendKeys(username);
        Thread.sleep(2000);

        String actualUsername= userNameInputBox.getAttribute("value");
        //getAttribute bize o element hakkinda bilgi verir.
        // Bir de eger bir send key soz konusu olan element ise, yazilan datayi verir

        if (actualUsername.equals(username)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        WebElement passwortInoutBox = driver.findElement(By.id("password"));
        passwortInoutBox.sendKeys("Test.!123");

        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();
        Thread.sleep(3000);


        WebElement actualLoggedInUsername=driver.findElement(By.id("userName-value"));
        String actualTest = actualLoggedInUsername.getText();

        if (actualTest.equals(username)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }


        driver.close();


    }
}
