package com.eurotech.tests.day_11_listOfElements_dropDowns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _3_DropDownWithoutSelectTag {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void dropDownWithhoutSelectTag() throws InterruptedException {

        /**
         * navigate to https://demoqa.com/select-menu
         * click Select Value dropdown
         * select (click) "Group 1, option 2" from Select Value dropdown
         * locate the new "Group 1, option 2" web element (stale element daha sonra anlatılacak)
         * verify that the element text is "Group 1, option 2"
         */


        driver.get("https://demoqa.com/select-menu");

        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Option']"));

        dropDownMenu.click();

        Thread.sleep(2000);

        WebElement grup1Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        grup1Option2.click();

        WebElement grup1Option2_1 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));

        String actualText= grup1Option2_1.getText();
        String expectedTex="Group 1, option 2";

        Assert.assertEquals(actualText,expectedTex);


    }

    @Test
    public void dropDownWithhoutSelectTag_Task() throws InterruptedException {

        /**
         * navigate to https://demoqa.com/select-menu
         * click Select One dropdown
         * click on 'Mrs.'
         * locate new 'Mrs.' webElement
         * get the selected option text verify that the text is "Mrs."
         *
         * NOT:right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
         */


        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);

        WebElement drobdown = driver.findElement(By.xpath("(//div[@class=' css-yk16xz-control'])[2]"));
        drobdown.click();

        driver.findElement(By.id("react-select-3-option-0-2")).click();
        Thread.sleep(2000);

        WebElement mrs = driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));

        String actual= mrs.getText();
        String axpected="Mrs.";

        Assert.assertEquals(actual,axpected);

//        if (actual.equals(axpected)){
//            System.out.println("pass");
//        }else {
//            System.out.println("fail");
//        }

    }
    @Test
    public void odev() throws InterruptedException {

        /**
         * navigate to https://demo.aspnetawesome.com/
         * locate and click DropdownList (Mango ile başlayan liste)
         * get all option names and print them
         * click potato by index (6)
         * relocate dropdown menu (çünkü listenin yapısı değişti)
         * click banana with its own locator (banana'yı locate edip tıklayalım.)
         */


        driver.get("https://demo.aspnetawesome.com/");
        Thread.sleep(2000);
        WebElement dropDownMenu = driver.findElement(By.xpath("(//div[text()='Mango'])[1]"));
        dropDownMenu.click();
        Thread.sleep(2000);

        List<WebElement> plantsMenu = driver.findElements(By.xpath("(//div[@class='o-itsc'])[5]//li"));
        System.out.println("plantsMenu.size() = " + plantsMenu.size());

        for (WebElement plant : plantsMenu) {
            System.out.println("food.getText() = " + plant.getText());
        }

        //click on potato
        plantsMenu.get(6).click();
        Thread.sleep(2000);

        WebElement dropDownMenu1 = driver.findElement(By.xpath("(//div[text()='Potato'])[1]"));
        dropDownMenu1.click();

        Thread.sleep(2000);

        //click on banana
        WebElement banana = driver.findElement(By.xpath("(//div[text()='Banana'])[2]"));
        banana.click();

        Thread.sleep(2000);



    }

    @Test
    public void staleElemet() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        System.out.println("header.getText() = " + header.getText());

        driver.navigate().refresh();
        WebElement header1 = driver.findElement(By.xpath("//div[text()='Swag Labs']"));

        System.out.println("header1.getText() = " + header1.getText());

    }
}
