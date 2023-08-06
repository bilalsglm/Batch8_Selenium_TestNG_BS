package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;

public interface LoginPageLocaters {

    By emailBox_loc=By.id("email");
    By passwordBox_loc=By.id("yourPassword");
    By logonBtn_loc=By.xpath("//*[text()='Login']");

    default void login(){
        Driver.get().findElement(emailBox_loc).sendKeys(ConfigurationReader.get("userEmail"));
        Driver.get().findElement(passwordBox_loc).sendKeys(ConfigurationReader.get("password"));
        Driver.get().findElement(logonBtn_loc).click();
    }

}
