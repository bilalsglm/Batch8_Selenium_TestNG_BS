package com.eurotech.tests.day_04;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_Review {
    public static void main(String[] args) {

        //Burada uzun sekilde yazma yontemi
        //Burada Utilities kullanmadan daha cok memory yorarak yazdik
        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://abeyis.com");


        //Daha efektif ve utilities kullanarak yazdigimiz yontem
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://abeyis.com");
        driver.get("https://www.abeyis.com");


    }
}
