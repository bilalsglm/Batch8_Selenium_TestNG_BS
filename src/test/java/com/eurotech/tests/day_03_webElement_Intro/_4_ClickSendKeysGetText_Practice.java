package com.eurotech.tests.day_03_webElement_Intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_ClickSendKeysGetText_Practice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Open chore browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * get result for text
         * verify that the text contains "Java"
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        //web elemeti kullanma yolları 1. yol
        // lazy way---> yani web elementi herhangi bir değişkene atamadan direkt kullanıyoruz burada
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java");

        Thread.sleep(2000);

        //web elemeti kullanma yolları 2. yol
        //burada web elementi bir değişkene atayarak kullanıyoruz... önce web elemnti tanımlayıp sonra click yapıyoruz..
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        Thread.sleep(2000);


        // burada bir web elementi locate etme (seleniuma gösterme, yerini belirleme) yöntemi olan xPath kullanıyoruz.
        WebElement results = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String actualText = results.getText();
        Thread.sleep(2000);

        String exceptedText="Java";

        if (actualText.contains(exceptedText)) {
            System.out.println("Arama sonuçları 'Java' içeriyor.");
        } else {
            System.out.println("Arama sonuçları 'Java' içermiyor.");
        }


        driver.quit();

    }
}


/**
 * Toplam 8 adet web element locate etme yöntemi vardir.
 ==================
 * 6 adedi basic yöntemler (basit-temel)
 * 1- By Id
 * 2- By Name
 * 3- By Tagname
 * 4- By Class name
 * 5- By linktext
 * 6- By partial link text
 ================
 * 2 adedi custom veya complex yöntemler (custom --> belirlenmiş kurallara göre )
 * 7- By xPath
 * 8- By Css selector
 */


