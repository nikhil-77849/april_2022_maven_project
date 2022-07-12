package com.testology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class DeskPage {


//hello testology

//Declaring
    @FindBy(xpath="//a//span[contains(text(),'Settings')]")
    public WebElement settingsDropDown;

    @FindBy(xpath="//div[contains(@data-module-name,'Stock')]")
    public WebElement stockDropDownElement;


    public DeskPage()
    {
        PageFactory.initElements(TestBase.driver,this);
    }

    //Definition of web elements
   // public WebElement stockDropDownElement=TestBase.driver.findElement(By.xpath(""));
}
