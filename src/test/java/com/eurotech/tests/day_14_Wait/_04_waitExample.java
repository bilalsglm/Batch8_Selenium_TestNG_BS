package com.eurotech.tests.day_14_Wait;

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

public class _04_waitExample {

    //Bu classı çalıştırmadan once utilities te implicitly yorum satırına al

    //implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
    //explicitly wait ise once obje olarak olusturulur sonra
    // sadece kullanildigi yerde ve belirlenen sarta gore calisir class yada test in tamamina uygulanmaz

    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("cHromE");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDowm() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void imlicitlyWaitTest1() {//imlicitlywait'in sn 10 utilities package'inde

//         1. Bir class olusturun : WaitTest
// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

// 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@type='button']")).click();

// 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement itsGone = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGone.isDisplayed());

// 6. Add buttonuna basin
        WebElement add = driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']"));
        add.click();

// 7. It's back mesajinin gorundugunu test edin
        WebElement itsback =driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(itsback.isDisplayed());
    }

    @Test
    public void explicitWaitTest2() {

//         1. Bir class olusturun : WaitTest
// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

// 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@type='button']")).click();

// 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement itsGoneWE = wait.until(ExpectedConditions.//itsGone elementi yükleninceye kadar bekle kodu
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneWE.isDisplayed());
// 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

// 7. It's back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBackWE.isDisplayed());

        //Soru-1
    /*
    Bu siteye gidiniz.  [https://www.seleniumeasy.com/test/basic-first-form-demo.html]
            (https://www.seleniumeasy.com/test/basic-first-form-demo.html)
    Input forms'a tıklayınız.
    Ajax from Submit'e tıklayınız.
    Name giriniz.
    Comment giriniz.
    Submit'e tıklayınız.
    Form submited Successfully! yazısı görüntülenmelidir.
    Yazıyı yazdırınız.


     */


        //Soru-2
    /*
    Senaryo
1-  https://www.demoblaze.com/index.html  siteyi açınız.
            2- Samsung galaxy s6  linkine tıklayınız.
3- Sepete ekleyiniz.
            4- Çıkan alerte accept yapınız.
            wait.until(ExpectedConditions.alertIsPresent());

     */

    }
}
