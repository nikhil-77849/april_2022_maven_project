package com.testology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class StockPage {


    @FindBy(xpath="//div[contains(@class,'title') and text()='Stock']")
    public WebElement stockPageTitle;


    public StockPage()
    {
        PageFactory.initElements(TestBase.driver,this);
    }

}
