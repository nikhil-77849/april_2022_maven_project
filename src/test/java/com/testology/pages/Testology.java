package com.testology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class Testology {

    @FindBy(xpath="//button[@class='menu-toggle']")
    public WebElement menuToggleBtn;


    public Testology()
    {
        PageFactory.initElements(TestBase.driver,this);
    }

}
