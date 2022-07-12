package com.testology.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class LoginPage {

    public String url="https://test.techlift.in/login#login";

    @FindBy(xpath="//input[@id='login_email']")
    public WebElement email;

    @FindBy(xpath="//input[@id='login_password']")
    public WebElement password;

    @FindBy(xpath="//button[contains(@class,'btn-login')]")
    public WebElement loginBtn;

public LoginPage()
{
    PageFactory.initElements(TestBase.driver,this);
}


}
