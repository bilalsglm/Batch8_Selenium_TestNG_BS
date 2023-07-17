package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import com.github.javafaker.Faker;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage{


        @FindBy(xpath = "(//button[text()='Add Experience'])[2]")
        public WebElement addExperienceBtn;

        @FindBy(xpath = "//input[@id='job']")
        public WebElement jobBox;

    public void fillingAddExperienceForm(){
        Actions actions=new Actions(Driver.get());
        actions.click(jobBox)
                    .sendKeys("QA"+ Keys.TAB)
                    .sendKeys("HHS"+Keys.TAB)
                    .sendKeys("Hannover"+Keys.TAB)
                    .sendKeys("10082020"+Keys.TAB+Keys.TAB)
                    .sendKeys("10032022"+Keys.TAB)
                    .sendKeys("Tester"+Keys.TAB+Keys.ENTER).perform();

//        Faker faker=new Faker();
//        String jobTitle = faker.name().fullName();
//        String company = faker.name().name();
//        String location=faker.address().city();
//        String formDate= String.valueOf(faker.date().birthday());
//        String toDate= String.valueOf(faker.date().birthday());
//        String description=faker.lorem().word();
//
//        actions.click(jobBox)
//                    .sendKeys("QA"+jobTitle+ Keys.TAB)
//                    .sendKeys(company+Keys.TAB)
//                    .sendKeys(location+Keys.TAB)
//                    .sendKeys(formDate+Keys.TAB+Keys.TAB)
//                    .sendKeys(toDate+Keys.TAB)
//                    .sendKeys(description+Keys.TAB+Keys.ENTER).perform();
    }
}
