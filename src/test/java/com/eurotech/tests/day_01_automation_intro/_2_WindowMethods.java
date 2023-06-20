package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_WindowMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://www.eurotech.study/");
       // driver.get("www.eurotech.study/");// calismaz
       // driver.get("http://eurotech.study/");// calsir


        //ekran buyutme
//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();

        //how to get position of the window
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        driver.manage().window().setPosition(new Point(50,200));

//        driver.manage().window().setPosition(new Point(-1000,0));
//        driver.manage().window().maximize();
//        Point position1 = driver.manage().window().getPosition();
//        System.out.println("position1 = " + position1);

        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size);

        Thread.sleep(2000);// java dan gelir codun execution islemini belli sureligine durduru

        //window ebatlari ayar
        driver.manage().window().setSize(new Dimension(50,900));

    }
}
