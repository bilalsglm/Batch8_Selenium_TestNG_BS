package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_BasicLocatorTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         *
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        Faker faker=new Faker();

        driver.get("https://www.browserstack.com/users/sign_up");

        Thread.sleep(2000);

        driver.findElement(By.id("accept-cookie-notification")).click();

        Thread.sleep(2000);

        // UserName
        WebElement userFullNameBox = driver.findElement(By.id("user_full_name"));
        String randomFulName=faker.name().fullName();
        userFullNameBox.sendKeys(randomFulName);

        Thread.sleep(2000);

        // E-mail
        WebElement userEmailLogin = driver.findElement(By.id("user_email_login"));
        String randomEmailBox=faker.internet().emailAddress();
        userEmailLogin.sendKeys(randomEmailBox);

        Thread.sleep(2000);

        //Password
        WebElement Password = driver.findElement(By.id("user_password"));
        String randomPaswordBox=faker.internet().password();
        Password.sendKeys(randomPaswordBox);

        Thread.sleep(2000);

        driver.findElement(By.id("tnc_checkbox")).click();

        Thread.sleep(2000);

        driver.close();

    }
}
