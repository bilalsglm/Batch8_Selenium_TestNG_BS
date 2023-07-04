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

public class _1_ListOfElements_FindElements {

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
    public void finElementsWithCorretFormula() throws InterruptedException {
        /**
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         */

        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);

        List<WebElement> headers=driver.findElements(By.cssSelector(".header-text"));

        //size'ın 6 olduğunu doğrulayalım
        int size = headers.size();
        System.out.println("size = " + size);

        Assert.assertEquals(size,6,"verify that size is 6");

        //elementlerin textini alalım
        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());

        }
        //lambda ile text alalim forEach() metodu ile
        headers.forEach(header-> System.out.println(header.getText()));

        //bütün başlıklar görünüyor mu?
        for (WebElement header : headers) {
            Assert.assertTrue(header.isDisplayed());
        }

    }

    @Test
    public void finElementsWithInCorretFormula() throws InterruptedException {


        /**
         * eğer findElements() metodu ile locate ettiğimiz WebElement listinin locator'ı hatalı olursa..
         * kod hata fırlatmaz, bunun yerine içi boş bir list elde etmiş oluruz..
         * eğer aynı işlem tek bir WebElement için yapılsaydı.. NoSuchElement hatası alacaktık...
         */

        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);

        List<WebElement> headers = driver.findElements(By.cssSelector(".bilal"));
        System.out.println("headers.size() = " + headers.size());







    }
    @Test
    public void findElemet() throws InterruptedException {
        /**
         * navigate to https://www.saucedemo.com/
         * locate login form elements with one locator (username box, password box and login button)
         * send "standard_user" to username box
         * send "secret_sauce" to password box
         * click Login button
         * then take all product names to a web element list and print the text of elements
         * verify that first web element text is "Sauce Labs Backpack"
         */

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        List<WebElement> inputs=driver.findElements(By.xpath("//input"));
        inputs.get(0).sendKeys("standard_user");
        inputs.get(1).sendKeys("secret_sauce");
        inputs.get(2).click();

        List<WebElement> itemNames=driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement itemName : itemNames) {
            System.out.println("itemName.getText() = " + itemName.getText());
        }

        String actualFistItemName=itemNames.get(0).getText();
        String expectedFistItemName="Sauce Labs Backpack";

        Assert.assertEquals(actualFistItemName,expectedFistItemName);

        }

        @Test
        public void findElement_Task() throws InterruptedException {

            /**
             * navigate to http://www.eurotech.study/
             * accept cookies
             * click login
             * locate emailBox, passBox and Login Button with one locator and put them in a list which named as inputs
             * verify that the size of list is 3
             * verify that the value of 3rd element is Login
             * send your credentials to related boxes and then click login button
             * verify success login with "Welcome ......." text
             * locate Experience Credentials and Education Credentials with findElements()
             * then get both element texts and print them
             */

            driver.get("http://www.eurotech.study/");
            Thread.sleep(2000);

            //accept cookies
            driver.findElement(By.id("rcc-confirm-button")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//a[@class='btn btn-light']")).click();
            Thread.sleep(2000);
            List<WebElement> inputs_1=driver.findElements(By.xpath("//input"));
            Thread.sleep(2000);

            int size=inputs_1.size();
            System.out.println("size = " + size);

            Assert.assertEquals(size,3,"verify that size is 3");

            inputs_1.get(0).sendKeys("lali@hotmail.com");
            inputs_1.get(1).sendKeys("lalilali");
            inputs_1.get(2).click();
            Thread.sleep(2000);


            WebElement welcome = driver.findElement(By.id("dashboard-p1"));
            System.out.println("welcome.getText() = " + welcome.getText());
            String actualNameTex = welcome.getText();
            String expectedNameTex="Welcome Lali";

            Assert.assertEquals(actualNameTex,expectedNameTex,"verify that the names are same");
            Thread.sleep(2000);


            WebElement expert = driver.findElement(By.id("dashboard-experience-h1"));
            System.out.println("expert.getText() = " + expert.getText());

            WebElement education = driver.findElement(By.id("dashboard-education-h1"));
            System.out.println("education.getText() = " + education.getText());


//            List<WebElement> experienceAndEducations= driver.findElements(By.xpath("//h2"));
//            System.out.println("experienceAndEducations.get(0).getText() = " + experienceAndEducations.get(0).getText());
//            System.out.println("experienceAndEducations.get(1).getText() = " + experienceAndEducations.get(1).getText());
//
//            for (WebElement experienceAndEducation : experienceAndEducations) {
//                System.out.println("experienceAndEducation.getText() = " + experienceAndEducation.getText());
//            }

        }


    }

/**
 * Açıklamalar....
 * findElements() --> bize WebElement'leri bir liste olarak döner.. (1 of 3 ise listede 3 element bulunur..)
 * List<WebElement> inputs = driver.findElements(By.xpath("xPathFormülü"));  // diğer yöntemler de kullanılabilir..
 * elements.get(0).click() --> listenin ilk elementine click yapar
 * elements.get(1).getText() --> listenin ikinci elementinin textini alır.
 * elements.get(2).isDisplayed() --> listenin üçüncü elementinin sayfada görünüp/görünmediğini doğrular..
 * ...
 * findElement() ve findElements() arasındaki farklar..
 * a.  findElement() --> WebElement döner, eğer elementi locate edemezse noSuchElementException fırlatır.
 * b.  findElements() --> WebElement listesi döner. eğer elementleri locate edemezse boş bir liste döner
 * bu nedenle hiçbir zaman noSuchElementException hatası fırlatmaz... bulursa dolu, bulamazsa boş liste verir.
 */
