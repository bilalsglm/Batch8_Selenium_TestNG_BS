package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement userProfilePageTitle;

    @FindBy(css = "div#profile-overview>div:nth-of-type(1)")
    public WebElement profileUptdaMasega;

    public void navigateUserProfileTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//li/button[text()='"+tabName+"']"));
        BrowserUtils.clickWithJS(tab);

    }

    public String addedEdicutionName(String schoolName){
        return Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]")).getText();

    }
    public void deleteEducationLastRecord(String schoolName){

        WebElement deleteBtn = Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]/ancestor::tr//a"));
        BrowserUtils.clickWithJS(deleteBtn);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    public String addedExperienceName(String jobName){
        return Driver.get().findElement(By.xpath("//span[text()='"+jobName+"']")).getText();

    }

    public void deleteExperienceLastRecord(String jobName){

        WebElement deleteBtn = Driver.get().findElement(By.xpath("(//span[text()='"+jobName+"'])/ancestor::tr//a"));
        BrowserUtils.clickWithJS(deleteBtn);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }
}
