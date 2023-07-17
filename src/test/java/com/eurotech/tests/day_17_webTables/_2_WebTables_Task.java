package com.eurotech.tests.day_17_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _2_WebTables_Task {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Task_1(){
        /**
         * Task-1
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the third cell of first row --> 45  and make verification
         * get the second cell of second row --> Jackson and make verification
         */


        WebElement firstRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[1]/td[3]"));
        String firstActual = firstRow.getText();
        String firstExpected="45";
        Assert.assertEquals(firstActual,firstExpected);

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='t01']//tr[3]//td[2]"));
        String secondActual=secondRow.getText();
        String secondExpected="Jackson";
        Assert.assertEquals(secondActual,secondExpected);

    }


    @Test
    public void Task_2(){
        /**
         * Task-2
         * navigate to https://webdriveruniversity.com/Data-Table/index.html
         * get the data of specific cell by using row and column numbers
         * write separate methods for this purpose
         * print whole table data by using this method (except column headers)
         */

        int sutunSayisi=getSutunSayisi();
        int satirSayisi=getSatirSayisi();

        for (int i = 1; i <= satirSayisi; i++) {
            for (int j = 1; j <=sutunSayisi ; j++) {
                System.out.print(hucreBilge(i, j)+" ");
            }
            System.out.println();
        }

    }
    private int getSatirSayisi() {
        List<WebElement> satir = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        return satir.size();
    }

    private int getSutunSayisi() {
        List<WebElement> sutun = driver.findElements(By.xpath("//table[@id='t01']/tbody/tr//th"));
        return sutun.size();
    }

    String hucreBilge(int satir,int sutun){

        String hucreXPath="(//table[@id='t01']//td/..)["+satir+"]/td["+sutun+"]";

        WebElement hucre = driver.findElement(By.xpath(hucreXPath));
        return hucre.getText();
    }


}
