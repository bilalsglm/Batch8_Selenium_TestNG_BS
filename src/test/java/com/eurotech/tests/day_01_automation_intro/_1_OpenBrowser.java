package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_OpenBrowser {
    public static void main(String[] args) {

        // make selenium ready to with Chrome

        WebDriverManager.chromiumdriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.edgedriver().setup();

        //create a driver object
        //driver--> repserent an am

        WebDriver driver1 = new ChromeDriver();
       // WebDriver driver2 = new FirefoxDriver();
       // WebDriver driver3 = new EdgeDriver();

        // navigate (go)to amazon web page

        //driver1.get("https://www.amazon.de");
        //driver2.get("https://www.amazon.de");
       // driver3.get("https://www.amazon.de");
        driver1.get("https://www.euroTechStudy.de");



        // hiw to page title

        String actualTitle=driver1.getTitle();
        //String expectedTitle="Amazon.de: Günstige Preise für Elektronik & Foto, Filme, Musik, Bücher, Games, Spielzeug & mehr";
        String expectedTitle="euroTech Study GmbH – Germany – Digital Career Programs und Training Courses";


        //check if the actual and expected values are match or more

        if (actualTitle.equals(expectedTitle)){
            System.out.println("\"Pass\" = " + "Pass");
        }else{
            System.out.println("\"Failed\" = " + "Failed");
        }



    }
}
