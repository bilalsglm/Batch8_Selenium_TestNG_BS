package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //public abstract void verifyPageTitle();

    @FindBy(css = ".nav-item")
    public List<WebElement> tabMenu;

    @FindBy(css = ".d-none.d-md-block.dropdown-toggle.ps-2")
    public WebElement userNameAtRigt;

    public List<String> getTabMenuNames(){
        List<String> list=new ArrayList<>();

        for (WebElement menu : tabMenu) {
            list.add(menu.getText());

        }
        return list;
    }

    public void navigateToTabsAndModule(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='" + tabName + "']"));
        tab.click();
    }
    public void navigateToTabsAndModule(String tabName,String modulName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='" + tabName + "']"));
        tab.click();
        if (!modulName.isEmpty()){
            WebElement modul = Driver.get().findElement(By.xpath("//span[text()='"+modulName+"']"));
            modul.click();
        }

    }
}
