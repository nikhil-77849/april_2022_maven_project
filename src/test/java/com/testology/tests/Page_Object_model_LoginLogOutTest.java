package com.testology.tests;

import com.testology.pages.DeskPage;
import com.testology.pages.LoginPage;
import com.testology.pages.StockPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;

import java.time.Duration;

public class Page_Object_model_LoginLogOutTest extends TestBase {


    WebDriverWait wait;// Explicit wait

@Parameters({"emailId","password"})
    @Test
    public void verify_user_is_able_to_login_with_valid_credentials(String emailIdValue, String passwordValue)  {


        driver.get("https://test.techlift.in/login#login");
    LoginPage loginPage = new LoginPage();
    loginPage.email.sendKeys(emailIdValue);
    loginPage.password.sendKeys(passwordValue);
    loginPage.loginBtn.click();
    wait = new WebDriverWait(driver,Duration.ofSeconds(3));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[contains(text(),'Settings')]")));

    DeskPage deskPage = new DeskPage();
        Assert.assertTrue(deskPage.settingsDropDown.isDisplayed());// assertion to check whether the settings dropdown is displayed
        // if this assertion passes then we are successfully logged in to test.techlift.in

    deskPage.stockDropDownElement.click();


    wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'title') and text()='Stock']")));
    StockPage stockPage= new StockPage();
    Assert.assertTrue(stockPage.stockPageTitle.isDisplayed());// assertion to check whether the settings dropdown is displayed

}

    @AfterTest
        public void terminateDriver()
{
    driver.close();
    driver.quit();
}



}
