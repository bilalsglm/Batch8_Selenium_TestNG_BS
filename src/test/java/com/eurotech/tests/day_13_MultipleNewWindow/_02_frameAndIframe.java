package com.eurotech.tests.day_13_MultipleNewWindow;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_frameAndIframe {

    //Frame yapisi: ic ice konumlandirilmis web sayfalarinin tanimlanmasi icin kullanilir
    //Burada Frame: Bir Web sayfasinda ic ice olmayacak sekilde konumlandirilmis durumu
    //IFrame ise --> ic ice konulmus web sayfalarinin tanimlanmasinda kullanilir
    //Frame yapisi inspect yapildiktan sonra iframe ile tekrardan html kod baslangicindan da anlasilir


    //Frame yapisina 3 farkli  sekilde erisilebilir
    //1-Attribute degeri ile  --> driver.switchTo.frame(frm1)
    //2-Index degerine gore  -->driver.switchTo.frame(0)  INDEX --> 0 ` dan baslar !!!!
    //3-Frame methoduna gore , yani bir web element tanimlanmasi ile gecis yapilabilir
    // --> Method = driver.switchTo.frame(driver.finByelement(By.Id ("")))
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void testframe1() throws InterruptedException {

        driver.get("https://demoqa.com/frames");

        Thread.sleep(2000);

        driver.switchTo().frame("frame1");//Verify with atribute value

        String tex= driver.findElement(By.id("sampleHeading")).getText();

        Assert.assertEquals(tex,"This is a sample page");
    }




    @Test
    public void testframe2() throws InterruptedException {

        driver.get("https://demoqa.com/frames");

        Thread.sleep(2000);

        driver.switchTo().frame(3);//Verify with index value
        driver.switchTo().parentFrame();//yan yana olan frame lerden hangi boyuta gecis olacak??


        String tex= driver.findElement(By.id("sampleHeading")).getText();

        Assert.assertEquals(tex,"This is a sample page");
    }

    @Test
    public void testframe3() throws InterruptedException {

        driver.get("https://demoqa.com/nestedframes");

        Thread.sleep(2000);

        driver.switchTo().frame("frame1");

        //driver.switchTo().frame(2);//Kac ktane ic ice frame oldugunda
        // driver.switchTo().parentFrame();//Bu index olarak ic ice olan frame den
        // adim adim disa cikma yontemidir.



        //   driver.switchTo().frame() --> int degeri, attribute degeri ve finBy degeri ile gidilir
        driver.switchTo().parentFrame();// Frame lerden yukari dogru cikis icin kullanilir
        //her bir parent bir adim yukari cikar

        driver.switchTo().frame(2);
        driver.switchTo().parentFrame();//driver.switchTo().frame(1);
        driver.switchTo().parentFrame();//driver.switchTo().frame(0);



        //oncesinde hic islem yok iken direkt olarak ana sayfaya gelir
        driver.switchTo().defaultContent();//Bu direkt default olan sayfaya gelir
        //Boyut olarak neredeyseniz, direkt ana sayfaya gelir
        // driver.switchTo().frame(0);


    }
}
