package com.eurotech.tests.day_21_extent_report;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ExtentReportDemo {

    //Bu class rapor olusturmak ve rapor ile ilgili metadate yi tanimlamak icin kullanilir.
    ExtentReports report;
    //Bu class rapatumuzun html formatatinda olmasini saglar.
    ExtentHtmlReporter htmlReporter;
    //Her test ile ilgili logg kayitlarini ve test adimlarini tanimlamamizi saglar
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup(){
        //initialize class
        report=new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        //rapor basligini duzenliyelim
        htmlReporter.config().setReportName("Smoke Test");

        //raporun metadatesini suzenleyelim
        //set environment information
        report.setSystemInfo("Environmet","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","BilalSaglam");
        report.setSystemInfo("PO","UmutIhsan");

    }
    @Test
    public void tset1(){

        extentLogger=report.createTest("TC001 Demo Test");

        extentLogger.info("Chrome browseri ac");
        //cod hear
        extentLogger.info("Web sitesine git"+ConfigurationReader.get("usl"));
        //cod hear
        extentLogger.info("emaili gir");
        //cod hear
        extentLogger.info("password gir");
        //cod hear
        extentLogger.info("logine click yap");
        //cod hear
        extentLogger.info("logine oldugunu kullanici adiyla "+ConfigurationReader.get("userName")+" ile dogrula");

        extentLogger.pass("Passed");
    }
    @AfterMethod
    public void tearDown(){
        //raporun gercek anlamda olusturuldugu yer
        report.flush();

    }
}
