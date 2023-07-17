package com.eurotech.tests.day_16_Review;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class _01_Example_ERP {

    WebDriver driver;

    //SENAYO # 1. Kullanıcı ilk önce haftalık ekrana gelir
    @BeforeMethod
    public void loginTest(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://qa.fidexio.com/web/login");
        driver.findElement(By.id("login")).sendKeys("posmanager75@info.com");
        driver.findElement(By.id("password")).sendKeys("posmanager");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Tum senaryolarda bir etkinlik takvimi belirlenirken bu calander butoon lazim oldugu icin buraya aldik
        driver.findElement(By.xpath("//a[@data-menu=\"120\"]")).click();//Calander button

    }
    @AfterMethod
    public void tearDown(){
      driver.close();
    }

    @Test
    public void firtScinario(){

        //User should be display weekly calander page  -Haftalik takvim gosterimi
        driver.findElement(By.xpath("//a[@data-menu=\"120\"]")).click();
        WebElement calenderWeek = driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[2]"));
        Assert.assertTrue(calenderWeek.getAttribute("class").contains("active"));
    }
    //SENAYO # 2. Kullanıcı Gün-Hafta-Ay gösterimini değiştirebilir
    @Test
    public void secontScinario(){
        //User shouldn`t be display day calander page  -Gunluk takvim gosterimi
        driver.findElement(By.xpath("//a[@data-menu=\"120\"]")).click();
        WebElement calenderWeek = driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[1]"));
        Assert.assertFalse(calenderWeek.getAttribute("class").contains("active"));
    }

    @Test
    public void thirdScinario(){
        //User shouldn`t be display aylik calander page  -Aylik takvim gosterimi
        driver.findElement(By.xpath("//a[@data-menu=\"120\"]")).click();
        WebElement calenderWeek = driver.findElement(By.xpath("//div[@class='btn-group btn-group-sm']/button[3]"));
        Assert.assertFalse(calenderWeek.getAttribute("class").contains("active"));
    }

    //SENARYO # 3. Kullanıcı, zaman kutusuna tıklayarak etkinlik oluşturabilir
    @Test
    public void fourthScinario(){
        //scinario : User can creat event by clicking timrBox
        //kullanici zaman kutusuna tiklayarak etkinlik olusturabilir

        //1- User click timeBox button
        driver.findElement(By.xpath("//tr[@class='fc-minor'][4]")).click();
        //2-User creat summary on creat meeting box with "summary demo"
        driver.findElement(By.xpath("//input[@class='o_input']")).sendKeys("summary demo"+ Keys.ENTER);
        //3- User cilck create button on create mieting
    }

    //SENARYO # 4. Kullanıcı, takvimde etkinliğe tıkladığında etkinlik ayrıntılarını görebilir.
    @Test
    public void displayEvent(){
        //1-User click created event
        driver.findElement(By.xpath("//div[@class='fc-content']")).click();
        //2-Verify Event Details
        WebElement title = driver.findElement(By.tagName("h4"));
        System.out.println("title.getText() = " + title.getText());
        Assert.assertTrue(title.isDisplayed());//Daha detayli bir verify yontemi lazim

        Assert.assertEquals(title.getText(),"Open: summary demo");//Daha tutarli bir verify yaptik

        WebElement editBtn = driver.findElement(By.xpath("//span[text()='Edit']"));
        WebElement deleteBtn = driver.findElement(By.xpath("//span[text()='Delete']"));
        WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']"));

        Assert.assertTrue(editBtn.isDisplayed());
        Assert.assertTrue(deleteBtn.isDisplayed());
        Assert.assertTrue(closeBtn.isDisplayed());

    }

    //SENARYO 5 # Kullanıcı oluşturulan bir etkinliği düzenleyebilir
    @Test
    public void editCalander() throws InterruptedException {

        Thread.sleep(2000);
        //0-click created event
        //driver.findElement(By.xpath("//a[@class='fc-time-grid-event fc-v-event fc-event fc-start fc-end fc-draggable fc-resizable o_calendar_color_6']")).click();

        driver.findElement(By.xpath("//div[@class='fc-content']")).click();

        //1-User click Edit button on Even detail
        WebElement editButton=driver.findElement(By.xpath("//span[text()='Edit']"));
        editButton.click();

        //2- User can see the page that edit event detail
        WebElement titleEdit= driver.findElement(By.xpath("//label[text()='Meeting Subject']"));

        Assert.assertEquals("Meeting Subject",titleEdit.getText());
        driver.findElement(By.xpath("//input[@class='o_field_char o_field_widget o_input o_required_modifier']")).sendKeys("Different Subject");

        Thread.sleep(2000);
        //3-User should edit Duration
        driver.findElement(By.xpath("//input[@name='duration']")).clear();//SendKeys yapilacak buton temizlendi
        driver.findElement(By.xpath("//input[@name='duration']")).sendKeys(Keys.CLEAR);
        driver.findElement(By.xpath("//input[@name='duration']")).sendKeys("00:35");//Yeni zaman yazildi



        //4-save button is displayed after that edit event title page
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Save']")).isDisplayed());

        Thread.sleep(3000);
        //5-Click Save button
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(driver,10);

        //6-User click on Calender Before created event
        WebElement eventBefore=driver.findElement(By.xpath("//div[@class='fc-content']"));
        wait.until(ExpectedConditions.elementToBeClickable(eventBefore)).click();

        //7-User click on Delete Button After edit
        WebElement deleteButton=driver.findElement(By.xpath("//span[text()='Delete']"));
        deleteButton.click();

        //8-Confirrm delete button
        driver.findElement(By.xpath("//span[text()='Ok']")).click();


    }

}
