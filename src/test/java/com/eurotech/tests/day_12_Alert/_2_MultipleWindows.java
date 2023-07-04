package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _2_MultipleWindows {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testMultipleWindows() throws InterruptedException {

        String mainHandle=driver.getWindowHandle(); //Hash KODu verir. Her sayfanin uniq hash kodu vardir
        System.out.println("mainHandle = " + mainHandle);


        WebElement newTabButton=driver.findElement(By.id("tabButton"));
        newTabButton.click();

        //Set methoduna otomatik olarak tum tablarin Hash kodunu atiyor.
        Set<String> allWindowsHandle=driver.getWindowHandles();//Tum sayfalarin Hash Kod larini burada topla

        //Bir Hash Kod Kumesinden yeni bir sayfaya gecis icin kullanilacak algoritma
        //Bir yeni tab acan link tiklanmasi durumunda, yeni tab veya sayfaya gecis islemi
        for (String handle : allWindowsHandle) {
            if (!handle.equals(mainHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                driver.close();
            }
            System.out.println("Listemizdeki Hash Kodlar : "+handle);

        }

        //Burada ilk ana sayfamiza Hash kodu ile ve switch to ile geri donduk. Sonrasinda after methodu calisip
        //Bu ilk olan main tab kapatacak
        Thread.sleep(1000);
        driver.switchTo().window(mainHandle);

    }
}
