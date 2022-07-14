package com.testology.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestBase;

import java.time.Duration;

public class LoginLogOutTest  extends TestBase {


  /*  @BeforeTest
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }*/

    @Test
    public void verify_user_is_able_to_login_with_valid_credentials() throws InterruptedException {

    driver.get("https://test.techlift.in/login#login");
        System.out.println("Navigating to https://test.techlift.in/login#login");
    Thread.sleep(5000);
        WebElement email=driver.findElement(By.xpath("//input[@id='login_email']"));

        WebElement password=driver.findElement(By.xpath("//input[@id='login_password']"));

        WebElement loginBtn=driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
        email.sendKeys("testology.qa.learning@gmail.com");
        password.sendKeys("Testology@123");
        loginBtn.click();
        System.out.println("Clicked on test.techlift.in login button");
    Thread.sleep(5000);
        WebElement settingsDropDown=driver.findElement(By.xpath("//a//span[contains(text(),'Settings')]"));
        Assert.assertTrue(settingsDropDown.isDisplayed());// assertion to check whether the settings dropdown is displayed
        // if this assertion passes then we are successfully logged in to test.techlift.in

    WebElement stockDropDownElement=driver.findElement(By.xpath("//div[contains(@data-module-name,'Stock')]"));
    stockDropDownElement.click();
        System.out.println("clicked on stockDropDownElement");
    Thread.sleep(5000);
    WebElement stockPageTitle=driver.findElement(By.xpath("//div[contains(@class,'title') and text()='Stock']"));
    Assert.assertTrue(stockPageTitle.isDisplayed());// assertion to check whether the settings dropdown is displayed
        System.out.println("Assertion Passed");
}

    @AfterTest
        public void terminateDriver()
{
    driver.close();
    driver.quit();
}



}
