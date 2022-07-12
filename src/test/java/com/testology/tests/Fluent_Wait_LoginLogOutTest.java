package com.testology.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;

import java.time.Duration;

public class Fluent_Wait_LoginLogOutTest extends TestBase {

    WebDriver driver ;
    Wait<WebDriver> wait;// fluent wait

    @BeforeTest
    public void setUp()
    {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();

    }
@Parameters({"emailId","password"})
    @Test
    public void verify_user_is_able_to_login_with_valid_credentials(String emailIdValue, String passwordValue)  {
        driver.get("https://test.techlift.in/login#login");

        WebElement email=driver.findElement(By.xpath("//input[@id='login_email']"));

        WebElement password=driver.findElement(By.xpath("//input[@id='login_password']"));

        WebElement loginBtn=driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
        email.sendKeys(emailIdValue);
        password.sendKeys(passwordValue);
        loginBtn.click();


    wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(1)) // by default the polling time is 500 ms for fluent and explicit wait
            .ignoring(NoSuchElementException.class);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[contains(text(),'Settings')]")));

        WebElement settingsDropDown=driver.findElement(By.xpath("//a//span[contains(text(),'Settings')]"));

        Assert.assertTrue(settingsDropDown.isDisplayed());// assertion to check whether the settings dropdown is displayed
        // if this assertion passes then we are successfully logged in to test.techlift.in

    WebElement stockDropDownElement=driver.findElement(By.xpath("//div[contains(@data-module-name,'Stock')]"));
    stockDropDownElement.click();



    wait.until(ExpectedConditions.titleIs("Stock"));

    WebElement stockPageTitle=driver.findElement(By.xpath("//div[contains(@class,'title') and text()='Stock']"));
    Assert.assertTrue(stockPageTitle.isDisplayed());// assertion to check whether the settings dropdown is displayed

}

    @AfterTest
        public void terminateDriver()
{
    driver.close();
    driver.quit();
}



}
