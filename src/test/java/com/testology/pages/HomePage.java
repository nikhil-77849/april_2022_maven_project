package com.testology.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class HomePage {

@FindBy(xpath = "//a[text()='Explore']")
    public WebElement exploreButton;

public HomePage()
{
    PageFactory.initElements(TestBase.driver,this);
}

}
