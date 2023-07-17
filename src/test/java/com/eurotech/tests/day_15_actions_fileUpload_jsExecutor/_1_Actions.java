package com.eurotech.tests.day_15_actions_fileUpload_jsExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _1_Actions {

    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void hoverOver() {

        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

        WebElement hoverPara = driver.findElement(By.id("hoverpara"));

        //Actions actions=new Actions(driver);

        actions.moveToElement(hoverPara).perform();

        WebElement hoverEffect = driver.findElement(By.id("hoverparaeffect"));

        String actualText=hoverEffect.getText();
        String expectedText="You can see this paragraph now that you hovered on the above 'button'.";

        Assert.assertEquals(actualText,expectedText);

        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(hoverEffect)).isDisplayed());

        WebElement hoverDiv = driver.findElement(By.id("hoverdivpara"));

        actions.moveToElement(hoverDiv).perform();

        Assert.assertTrue(new WebDriverWait(driver,12).until(ExpectedConditions.invisibilityOf(hoverEffect)));




    }

    @Test
    public void hoverOver_Task() {

        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */

        driver.get("lhttps://the-internet.herokuapp.com/hovers");
        List<WebElement> elements = driver.findElements(By.cssSelector(".figure"));

        for (WebElement element : elements) {
            actions.moveToElement(element).perform();

//            Assert.assertTrue(new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(elements.get(0))).isDisplayed());
//            Assert.assertTrue(new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(elements.get(1))).isDisplayed());
//            Assert.assertTrue(new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(elements.get(2))).isDisplayed());


            // Verify that "name:user1-2-3" is displayed
            WebElement userInfo = element.findElement(By.cssSelector(".figcaption"));
            String displayedName = userInfo.getText();
            if (displayedName.equals("name:user1-2-3")) {
                System.out.println("Verification Passed: " + displayedName);
            } else {
                System.out.println("Verification Failed: " + displayedName);
            }
        }


//        driver.get("https://the-internet.herokuapp.com/hovers");
//        Actions actions = new Actions(driver);
//        for (int i = 2; i <=4 ; i++) {
//
//            String imgXpath="(//img)["+i+"]";
//            //üzerinde hover yapılan elementlere img dersek
//            WebElement img=driver.findElement(By.xpath(imgXpath));
//
//            actions.moveToElement(img).perform();
//
//            String textXpath="//h5[text()='name: user"+(i-1)+"']";
//            //üzerinde hover yapılınca altta çıkan yazılara text dersek
//            WebElement text=driver.findElement(By.xpath(textXpath));
//
//            Assert.assertTrue(text.isDisplayed());



    }

    @Test
    public void dragAndDrop() {

        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement dragElement = driver.findElement(By.id("draggable"));

        WebElement dropElement = driver.findElement(By.id("droppable"));

        //Actions actions =new Actions(driver);

        //1.yol
        actions.dragAndDrop(dragElement,dropElement).perform();

        //2.yol
       // actions.moveToElement(dragElement).clickAndHold().pause(2000).

        WebElement dropText = driver.findElement(By.cssSelector("#droppable>p>b"));

        Assert.assertEquals(dropText.getText(),"Dropped!");

        Assert.assertTrue(dropText.isDisplayed());


    }

    @Test
    public void dragAndDrop_Task() {

        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */

        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable,droppable).perform();

        WebElement dropText = driver.findElement(By.xpath("//p[text()='Dropped!']"));

        Assert.assertEquals(dropText.getText(),"Dropped!");


    }

    @Test
    public void clickWithAction() throws InterruptedException {

        /**
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         * click on Right Click Test link from left menu (use actions)
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */

        driver.get("https://skill-test.net/mouse-double-click");

        WebElement clicker = driver.findElement(By.id("clicker"));

       // Actions actions=new Actions(driver);

        actions.doubleClick(clicker).perform();

        actions.moveToElement(clicker).doubleClick().perform();

        actions.click(clicker).perform();

        actions.moveToElement(clicker,5,6).click().perform();


        WebElement rightClick = driver.findElement(By.xpath("//span[text()='Right Click Test']"));

        actions.click(rightClick).perform();

        WebElement startBtn = driver.findElement(By.id("clicker"));

        actions.contextClick(startBtn).perform();

        Thread.sleep(2000);

        WebElement resetBtn = driver.findElement(By.id("reset"));
        actions.click(resetBtn).perform();


    }

    @Test
    public void filingFormWithAction() {

        /**
         * go to http://www.eurotech.study/
         * accept cookies
         * click login
         * send your credentials to related boxes and then click login button
         * click on Add Experience link
         * fill form with action class
         * verify the success message after submitted the form
         */

        driver.get("http://www.eurotech.study/");

        driver.findElement(By.id("rcc-confirm-button")).click();

        WebElement loginBtn = driver.findElement(By.cssSelector(".btn.btn-light"));
        loginBtn.click();

        //List<WebElement> inputs= (List<WebElement>) driver.findElement(By.xpath("//input"));
        List<WebElement> inputs=driver.findElements(By.xpath("//input"));

        inputs.get(0).sendKeys("lali@hotmail.com");
        inputs.get(1).sendKeys("lalilali");
        inputs.get(2).click();

        WebElement addExperence = driver.findElement(By.linkText("Add Experience"));
        addExperence.click();

        WebElement jobtitle = driver.findElement(By.id("addexperience-jobtitle-input"));

        actions.click(jobtitle)
                .sendKeys("QA Engineer"+ Keys.TAB)
                .sendKeys("Google Inc"+Keys.TAB)
                .sendKeys("Berlin"+Keys.TAB)
                .sendKeys("01012020"+Keys.TAB+Keys.TAB)
                .sendKeys("11112022"+Keys.TAB+Keys.TAB)
                .sendKeys("Nice Job"+Keys.TAB+Keys.ENTER).perform();

        String expectedMessage="Experience Added";
        String actualMessage=driver.findElement(By.cssSelector(".alert.alert-success")).getText();


        Assert.assertEquals(actualMessage,expectedMessage);


    }

    @Test
    public void rightClickOpenNewTab() throws InterruptedException {

        /**
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sağ ctrl+click)
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);

        WebElement link = driver.findElement(By.linkText("EvilTester.com"));
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(link)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String actualTitle=driver.getTitle();
        String expectedTitle="EvilTester.com";

        Assert.assertEquals(actualTitle,expectedTitle);



    }

}
