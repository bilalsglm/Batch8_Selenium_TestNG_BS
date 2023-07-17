package com.eurotech.tests.day_20_pom_2;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _4_StaleElement {

    @Test
    public void staleElement(){

        /**
         * go to kraft login page
         * enter your email and pass
         * refresh page
         * enter email and pass again
         * click login
         * enter the web page
         *
         * how to handle stale element problem...
         * stale element hatasını nasıl çözeriz..
         */

        WebDriver driver= Driver.get();
        driver.manage().window().maximize();

        driver.get(ConfigurationReader.get("url"));

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));

        driver.navigate().refresh();


        try {
            emailBox.sendKeys(ConfigurationReader.get("userEmail"));
            passwordBox.sendKeys(ConfigurationReader.get("password"));
        }catch (Exception e){
           emailBox = driver.findElement(By.id("email"));
            passwordBox = driver.findElement(By.id("yourPassword"));
            loginBtn = driver.findElement(By.xpath("//*[text()='Login']"));

            emailBox.sendKeys(ConfigurationReader.get("userEmail"));
            passwordBox.sendKeys(ConfigurationReader.get("password"));
            loginBtn.click();
            e.printStackTrace();
        }
        driver.quit();
    }
}
