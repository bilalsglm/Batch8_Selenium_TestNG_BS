package com.eurotech.tests.day_13_Iframe_Review;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_Iframes {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();//Coklu windows yapilarda tum sayfalari kapatmak icin QUIT methodu kullandik
    }

    @Test
    public void iframeWithIdAndWebElement() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by id
         * take the "iFrame" heading and print it
         * return to main html
         * switch to second frame by web element
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);

        driver.switchTo().frame("thedynamichtml");

        WebElement title1 = driver.findElement(By.tagName("h1"));
        System.out.println("title1 = " + title1.getText());

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();

        WebElement frame2 = driver.findElement(By.cssSelector("[src=\"frames/frames-header.html\"]"));
        driver.switchTo().frame(frame2);

        WebElement title2 = driver.findElement(By.tagName("h1"));
        System.out.println("title2 = " + title2.getText());

        driver.switchTo().defaultContent();

        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println("title = " + title.getText());

    }

    @Test
    public void iframeWithIndex() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by index
         * take the "iFrame" heading and print it
         * return to main html  (default content)
         * switch to second frame by index
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);

        driver.switchTo().frame(0);

        WebElement title1 = driver.findElement(By.tagName("h1"));
        System.out.println("title1 = " + title1.getText());

        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();


        driver.switchTo().frame(1);

        WebElement title2 = driver.findElement(By.tagName("h1"));
        System.out.println("title2 = " + title2.getText());

        driver.switchTo().defaultContent();

        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println("title = " + title.getText());
    }

    @Test
    public void nestedFrame_Task() throws InterruptedException {


        /**
         * navigate to https://testpages.herokuapp.com/styled/frames/frames-test.html
         * switch to top frame by name attribute
         * take the "Nested Frames Example" heading and print it
         * return to main html
         * switch to left frame by name attribute
         * take the "Left" heading and print it
         * return to main html
         * switch to middle frame by index
         * take the "Middle" heading and print it
         * return to main html
         * switch to right frame by web element
         * take the "Right" heading and print it
         * return to main html
         * switch to footer frame by index
         * take the "EvilTester.com" link text and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);



    }

    @Test
    public void nestedFrames() throws InterruptedException {

        /**
         * navigate to https://demoqa.com/nestedframes
         * switch to parent frame by id
         * take the "Parent frame" heading and print it
         * switch to child frame by index
         * take the "Child frame" heading and print it
         * switch to main frame related method
         * take the "Nested Frames" heading and print it
         */


        driver.get("https://demoqa.com/nestedframes");
        Thread.sleep(2000);

        driver.switchTo().frame("frame1");

        String headingParent = driver.findElement(By.tagName("body")).getText();
        System.out.println("headingParent = " + headingParent);

        driver.switchTo().frame(0);
        String headinhChild = driver.findElement(By.tagName("p")).getText();
        System.out.println("headinhChild = " + headinhChild);

        driver.switchTo().defaultContent();

        String mainHeading = driver.findElement(By.cssSelector(".main-header")).getText();
        System.out.println("mainHeading = " + mainHeading);

    }
    /**
     * No Such Element Exception aldığımızda
     * 1- Locator might be wrong or dynamic or not correct-Locator/konumlandırıcı
     yanlış veya dinamik olabilir veya doğru olmayabilir.
     * 2- Not enough wait time - Yeterli bekleme süresi yok
     * 3- There is a frame or iframe -Bir frame veya iframe var !
     - Html'de bir HTML sayfasının içinde bir diğer HTML yapısı olabilir.
     - Bu, <iframe> veya <frame> etiketi ile sağlanır.
     - Frame varsa, selenyum frame içinde ne olduğunu kontrol edemez.
     - Önce iframe'i değiştirmeliyiz. (switchTo() metodu ile)
     - iframe'e geçtiğimizde, selenium biz geri değiştirene kadar ana HTML sayfasını ve diğer frame yapılarını göremez,
     - Bir seferde sadece bir frame değiştirebiliriz ve torunlara doğrudan geçilmez.
     - kardeş/sibling arası geçiş/switch olmaz sadece ebeveynden çocuğa/parentchild.
     - child frameden bir üste yani parenta switchTo().parentFrame(); ile geçeriz.
     - en üstteki ana HTML (default) yapısına ise switchTo().defaultContent(); ile geçebiliriz.
     - bulunduğumuz frame'den bir üste ya da en üste (ana HTML) geçiş vardır. iki, üç vb. üstlere geçiş yoktur.
     - switchTo().frame()----> üç farklı parametre ile çalışır...
     1. id ya da name attribute değeri ile  ex: driver.switchTo().frame("frame1");
     2. index numarası ile ex:  driver.switchTo().frame(0);
     3. Web Element ile  ex: WebElement frame2 = driver.findElement(By.cssSelector("[src='frames/frames-header.html']"));
     driver.switchTo().frame(frame2);
     */
}
