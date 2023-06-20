package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_ById {
    public static void main(String[] args) throws InterruptedException {

         /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate DevEx web element by using id locator
         * get the text of web element and print it
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies //lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        //id ile locate etme
        WebElement devElement = driver.findElement(By.id("landingpage-innercontainer-h1"));
        //web elementin textini alalım ve yazdıralım
        String devElementText = devElement.getText();
        System.out.println(devElementText);
        Thread.sleep(2000);

        driver.close();


    }
}

             /*
             1- id ler cogunlukla unique(essiz)olur . Ancak yine de kontrol etmek gerekir
             2- id nin unique olup olmadigi dev tools ta arama (ctr+f) bolumunde basina # isareti konularak kontrol edilir
             3- bir elementin id si varsa locate isleminde id si kullanilr. oncelik id ye birakilir.
             4- id ler nadiren de olsa dinamik(degisken) olabilir. bunu sayfayi refresh yaparak konrtol edebiliriz.
             refresh yapildiginda degismiyorsa static degeri vardir
            */