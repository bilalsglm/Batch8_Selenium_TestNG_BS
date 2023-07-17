package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{

    @FindBy(xpath = "//div/button[text()='Add Education']")
    public WebElement addEducationBtn;

    @FindBy(css = "#school")
    public WebElement schoolBox;
    public void fillingAddEducationForm(String schoolName, String degree,String study,String fromDate,String toDate,String description){
        Actions actions=new Actions(Driver.get());
        actions.click(schoolBox)
                .sendKeys(schoolName+ Keys.TAB)
                .sendKeys(degree+Keys.TAB)
                .sendKeys(study+Keys.TAB)
                .sendKeys(fromDate+Keys.TAB+Keys.TAB)
                .sendKeys(toDate+Keys.TAB)
                .sendKeys(description+Keys.TAB+Keys.ENTER).perform();


    }
}
