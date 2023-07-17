package com.eurotech.tests.day_17_webTables;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _1_WebTables {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printWholeTable(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the whole data from table (including column headers)
         * verify that the table contains fbach@yahoo.com
         * and print all table datas
         */


        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        String wholeText = table.getText();
        System.out.println("wholeText = " + wholeText);

        System.out.println("wholeText.length() = " + wholeText.length());

        String expectedDate="fbach@yahoo.com";

        Assert.assertTrue(wholeText.contains(expectedDate));
    }

    @Test
    public void getAllColumnHeaders(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the column headers
         * verify that the column headers contains First Name
         * and print all headers' name
         */

        WebElement columnHeaders = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));

        String colummName = columnHeaders.getText();

        String expectedHedaers="First Name";

        Assert.assertTrue(colummName.contains(expectedHedaers));

        System.out.println("colummName = " + colummName);

    }

    @Test
    public void getColumnHeadersOneByOne(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get all web elements of column names  to a list
         * print all column names
         */

        List<WebElement> columnHeaders = driver.findElements(By.xpath("//table[@id='table1']//th"));

        columnHeaders.forEach(headers-> System.out.println(headers.getText()));

        for (WebElement header : columnHeaders) {
            System.out.println("header.getText() = " + header.getText());

        }
    }

    @Test
    public void getSingleRow(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info and print it
         * get all row and print them
         * get all row dynamically and print them
         */
        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("secondRow.getText() = " + secondRow.getText());

        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println("---------------------------------------------");

        for (WebElement row : allRowsWithoutHeaders) {
            System.out.println("row.getText() = " + row.getText());
        }

        System.out.println("---------------------------------------------");

        String dynamicallyRowText=dateOfRow(3);
        System.out.println("dynamicallyRowText = " + dynamicallyRowText);

    }

    @Test
    public void getAllCellInOneRow(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the second row info cell by cell and print it
         */

        List<WebElement> secondRowDate = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
        for (WebElement cellDate : secondRowDate) {
            System.out.println("cellDate.getText() = " + cellDate.getText());
        }
        System.out.println("due = " + secondRowDate.get(3).getText());
    }

    @Test
    public void getSingeleCellOfTable(){

        /**
         * navigate to https://the-internet.herokuapp.com/tables
         * get the data of specific cell by using row and column numbers
         */

        int nummerOfColumns=getNummerOfColumns();
        int nummerOfRows=getNummerOfRows();

        System.out.println("nummerOfColumns = " + nummerOfColumns);
        System.out.println("nummerOfRows = " + nummerOfRows);

        System.out.println("dateOfCell(4,2) = " + dateOfCell(4, 2));

        for (int i = 1; i <= nummerOfRows; i++) {
            for (int j = 1; j <= nummerOfColumns; j++) {
                System.out.print(dateOfCell(i, j)+" ");
            }
            System.out.println();
        }
    }

    private int getNummerOfRows() {
        List<WebElement> allRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        return allRow.size();
    }

    private int getNummerOfColumns() {
        List<WebElement> collumns = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
        return collumns.size();
    }

    private String dateOfRow(int rowNummer) {
        String xPath="//table[@id='table1']/tbody/tr["+rowNummer+"]";
        WebElement row = driver.findElement(By.xpath(xPath));
        return row.getText();
    }

    private String dateOfCell(int row,int column){
        String cellXpath="//table[@id='table1']/tbody/tr["+row+"]/td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(cellXpath));
        return cell.getText();
    }
}
/**
 * WebTables
 * In html tables are represented with <table> tag -- tablonun tamamını temsil eder
 * Tables are made of <thead> and <tbody> -- tablolar genellikle <thead> ve <tbody> bölümlerinden oluşur.
 * <thead> --> this is the table header, here we have table column names -- sütun başlıklarını tanımlamak içindir.
 * <tr> table row, indicates one whole row  -- tablodaki bütün bir satırı tanımlar.
 * <th> --> this tag indicates a cell that is used for table headers  -- tek bir sütun/satır başlığını tanımlamak içindir
 * <tbody> this is where the data is -- tablonun verisinin olduğu bölümü tanımlar.
 * <tr> table row, indicates one whole row -- tablodaki bütün bir satırı tanımlar.
 * <td> --> cell in a table body  -- hücreyi tanımlar ve veri burada tutulur.
 *
 * Note : Web Table'lardan veri çekmek için xPath kullanmak gerekir. (index ve child to parent işlevi nedeniyle)
 */
