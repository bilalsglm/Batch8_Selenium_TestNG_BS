package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilPage extends BasePage{

    @FindBy(id = "about")
    public WebElement aboutBox;

    @FindBy(xpath = "(//input[@id='company'])[1]")
    public WebElement companyBox;

    @FindBy(xpath = "//select[@id='job']")
    public WebElement jobSelect;

    @FindBy(id = "website")
    public WebElement websiteBox;

    @FindBy(xpath = "(//input[@id='location'])[1]")
    public WebElement locationBox;

    @FindBy(id = "skills")
    public WebElement skillsBox;

    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesBox;

    public void selectJob(String jobOption){
        Select select=new Select(jobSelect);
        select.selectByVisibleText(jobOption);
    }

    public String getSelected(){
        Select select=new Select(jobSelect);
        return select.getFirstSelectedOption().getText();
    }

}
