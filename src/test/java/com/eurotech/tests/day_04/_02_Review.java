package com.eurotech.tests.day_04;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _02_Review {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * register and login (send mail and password)
         * Verify title
         * Verify page
         * Verify back and forward

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(3000);//Thread-->Yazilimda bir Islem parcasi,
        // Pause tusuna basmak olarak algilanabilir

        //driver.findElement(By.id("rcc-confirm-button")).click(); kisa sekli
        WebElement cookiesButton = driver.findElement(By.id("rcc-confirm-button")); //ayni sonucu verir
        cookiesButton.click();

        Thread.sleep(3000);

        //Bu bir webelement olarak tanimladik ve sonra click dedik
        WebElement loginBtn = driver.findElement(By.xpath("//a[@class=\"btn btn-light\"]"));
        loginBtn.click();
        Thread.sleep(3000);

//        String email="lali@hotmail.com";
//        WebElement emailBox= driver.findElement(By.id("loginpage-input-email"));
//        emailBox.sendKeys(email);
        driver.findElement(By.id("loginpage-input-email")).sendKeys("lali@hotmail.com");

        Thread.sleep(3000);

//        String passwort= "lalilali";
//        WebElement paswortBox=driver.findElement(By.id("loginpage-form-pw-input"));
//        paswortBox.sendKeys(passwort);

        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys("lalilali");
        Thread.sleep(3000);

        driver.findElement(By.id("loginpage-form-btn")).click();

        Thread.sleep(3000);

        //driver.findElement(By.xpath("//a[@class=\"btn btn-primary my-1\"]")).click();
        //Thread.sleep(3000);


        String actualtUrl = driver.getCurrentUrl();
        System.out.println(actualtUrl);
        String expectedUrl="http://www.eurotech.study/dashboard";
        Thread.sleep(3000);

        if (actualtUrl.equals(expectedUrl)){
            System.out.println("Sayfa basarili sekilde yuklendi");
        }else {
            System.out.println("Hatali");
        }

        driver.getTitle();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class=\"btn btn-primary my-1\"]")).click();

        Thread.sleep(3000);
        driver.close();
    }
}
