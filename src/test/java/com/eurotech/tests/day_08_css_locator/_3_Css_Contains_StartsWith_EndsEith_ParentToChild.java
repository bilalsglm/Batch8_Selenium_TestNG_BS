package com.eurotech.tests.day_08_css_locator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_Css_Contains_StartsWith_EndsEith_ParentToChild {
    public static void main(String[] args) throws InterruptedException {

        /**
         * class task
         * navigate to http://www.eurotech.study/
         * click cookies button css contains (*)
         * click login button with css starts-with (^)
         * send your email to email box with css ends-with ($)
         * send your password to password box with css parent to child (>)
         * click login btn with css parent to grandson (space)
         * -----------------------------
         * [attribute*='value'] (contains)
         * tagName[attribute*='value'] (contains)
         *
         * [attribute^='firstPartOfValue'] (starts with)
         * tagName[attribute^='firstPartOfValue'] (starts with)
         *
         * [attribute$='lastPartOfValue'] (ends-with)
         * tagName[attribute$='lastPartOfValue'] (ends-with)
         *
         * xpath '/'  --> parent to child
         * css   '>'  --> parent to child
         * xpath '//' --> parent to grandson
         * css   ' '  --> parent to grandson  (space-boşluk)
         *   */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement cookieBtn = driver.findElement(By.cssSelector("[id*='rcc']"));
        cookieBtn.click();
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.cssSelector("[class^='btn btn-l']"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.cssSelector("[name$='il']"));
        emailBox.sendKeys("lali@hotmail.com");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.cssSelector("div>[name='password']"));
        password.sendKeys("lalilali");
        Thread.sleep(2000);

        WebElement loginBtnn = driver.findElement(By.cssSelector("section [type='submit']"));
        loginBtnn.click();
        Thread.sleep(3000);

        driver.close();

//        //click cookies button css contains (*)
//        driver.findElement(By.cssSelector("[aria-label*=' cookies']")).click();
//        Thread.sleep(2000);
//
//        //click login button with css starts-with (^)  //lazy way
//        driver.findElement(By.cssSelector("a[class^='btn btn-l']")).click();
//        Thread.sleep(2000);
//
//        //send your email to email box with css ends-with ($)   //lazy way
//        driver.findElement(By.cssSelector("[name$='l']")).sendKeys("sgezer56@gmail.com");
//        Thread.sleep(2000);
//
//        //send your password to password box with css parent to child (>)    //lazy way
//        driver.findElement(By.cssSelector("div>input[name='password']")).sendKeys("Sg12345678");
//        Thread.sleep(2000);
//
//        //click login btn with css parent to grandson (space) //lazy way
//        driver.findElement(By.cssSelector("section [type='submit']")).click();
//        Thread.sleep(2000);
//
//        driver.close();

    }
}
