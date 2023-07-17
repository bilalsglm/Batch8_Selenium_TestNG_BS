package com.eurotech.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;

    protected ExtentReports report;
   protected ExtentHtmlReporter htmlReporter;
   protected ExtentTest extentLogger;

    @BeforeTest
    public void setupTest(){

            report=new ExtentReports();

            String projectPath = System.getProperty("user.dir");
            String reportPath=projectPath+"/test-output/report.html";

//            String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//            String reportPath=projectPath+"/test-output/report"+date+".html";

            htmlReporter=new ExtentHtmlReporter(reportPath);

            report.attachReporter(htmlReporter);

            htmlReporter.config().setReportName("Smoke Test");

            report.setSystemInfo("Environmet","QA");
            report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
            report.setSystemInfo("OS",System.getProperty("os.name"));
            report.setSystemInfo("Test Engineer","BilalSaglam");
            report.setSystemInfo("PO","UmutIhsan");
    }
    @AfterTest
    public void tearDownTest(){
        report.flush();

    }

    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        action=new Actions(driver);
        //wait=new WebDriverWait(Driver.get(),10);
        wait=new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //Test basraisiz olursa

        if (result.getStatus()==ITestResult.FAILURE){
            //basarisiz taetin adini alma
            extentLogger.fail(result.getName());
            //ekran goruntusu
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotPath);
            extentLogger.fail(result.getThrowable());


        }

       Driver.closeDriver();
    }
}
