package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.concurrent.ThreadSafe;

public class _1_Alert01 {

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void testAlert() throws InterruptedException {


        WebElement alert1 = driver.findElement(By.id("alertButton"));
        alert1.click();

        Thread.sleep(2000);

//        WebDriverWait wait=new WebDriverWait(driver,2);
//        wait.until(ExpectedConditions.alertIsPresent());

        //Gerek Alert olsun gerek baska bir sayfa olsun,
        //Mevcut sayfanin disinda bir popHup veya windows uzerinde islem yapilabilmek
        //swich to ile islem yeri degistirilmeli

        Thread.sleep(2000);

        driver.switchTo().alert().accept();
        //driver dan switch ile yer degistirdik
        //alert uzerinde islem yapma yetkisi aldik
        //accept ile alert ile ilgili KABUL islemi yapmis oluyoruz. Alert uzerinde.

        Thread.sleep(2000);



    }

    @Test
    public void testTimeAlert() throws InterruptedException {

        WebElement alertTime = driver.findElement(By.id("timerAlertButton"));
        alertTime.click();

        Thread.sleep(7000);

//        Assert.assertTrue(alertTime.isDisplayed());
//        Thread.sleep(2000);

        String actualText = driver.switchTo().alert().getText();//Burada cikan Alert uzerindeki Tex alma islemi

        String expectedText= "This alert appeared after 5 seconds";

        //Senaryonuza gore sekil alan bir VERIFY etme yontemidir. QA`in Temel Gorevidir
        Assert.assertEquals(actualText,expectedText,"Actual result is not as expected!!");

        driver.switchTo().alert().accept();//Burada daha yeni Alert kabul ettim

//        WebElement texBox=driver.findElement(By.xpath("//span[text()='Text Box']"));
//        Assert.assertTrue(texBox.isDisplayed());
        //Sadece bu locate gorunur durumda mi? Diye sorgulamis oluyoruz. Sordugumuz sey Web element.

    }

    @Test
    public void testAlertDismisAndAccept() throws InterruptedException {
        WebElement alert2 = driver.findElement(By.id("confirmButton"));
        alert2.click();
        Thread.sleep(3000);

        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        WebElement alertResult= driver.findElement(By.id("confirmResult"));

        Assert.assertTrue(alertResult.getText().contains("Cancel"));


    }

    @Test
    public void testAlertDismisAndAccept() throws InterruptedException {

        WebElement alert2=driver.findElement(By.id("confirmButton"));
        alert2.click();

        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();//Burada alert olarak gelen uyari penceresindeki texi RED etme

        Thread.sleep(2000);

        WebElement alertResult=driver.findElement(By.id("confirmResult"));

        //Scenirao: Alert butonu dismis edildikten sonra gelen sonuc mesajinin icerisinde
        // Cancel gecip gecmedigini Verify ettik
        Assert.assertTrue(alertResult.getText().contains("Cancel"));

    }


    @Test
    public void testAlertSendKey() throws InterruptedException {
        WebElement alert3=driver.findElement(By.id("promtButton"));
        alert3.click();

        /*

        Alert alert4=driver.switchTo().alert();//Alert icin her seferinde switch to ve alert
                                             // uzantilarini kullanmadan islem yapmamizi saglar


        alert4.sendKeys("ismet");
        String text=alert4.getText();//Please enter your name
        Assert.assertEquals(alert4.getText(),"Please enter your name");
        alert4.accept();//Kabul
       // alert4.dismiss();//RED etme


         */

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("ismet");

        Thread.sleep(3000);

        driver.switchTo().alert().accept();

        WebElement alertNameTex=driver.findElement(By.id("promptResult"));

        Assert.assertTrue(alertNameTex.getText().contains("ismet"));//Positive Senaryo
        Assert.assertFalse(alertNameTex.getText().contains("123"));//Negative Senaryo
    }
}
