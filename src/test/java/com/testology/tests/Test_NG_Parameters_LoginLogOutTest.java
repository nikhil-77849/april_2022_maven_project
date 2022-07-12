package com.testology.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.TestBase;

public class Test_NG_Parameters_LoginLogOutTest extends TestBase {


  /*  @BeforeTest
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }*/
@Parameters({"emailId","password"})
    @Test
    public void verify_user_is_able_to_login_with_valid_credentials(String emailIdValue, String passwordValue) throws InterruptedException {
    WebElement email=driver.findElement(By.xpath("//input[@id='login_email']"));

    WebElement password=driver.findElement(By.xpath("//input[@id='login_password']"));

    WebElement loginBtn=driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
    driver.get("https://test.techlift.in/login#login");
    Thread.sleep(5000);

        email.sendKeys(emailIdValue);
        password.sendKeys(passwordValue);
        loginBtn.click();
    Thread.sleep(5000);
        WebElement settingsDropDown=driver.findElement(By.xpath("//a//span[contains(text(),'Settings')]"));
        Assert.assertTrue(settingsDropDown.isDisplayed());// assertion to check whether the settings dropdown is displayed
        // if this assertion passes then we are successfully logged in to test.techlift.in

    WebElement stockDropDownElement=driver.findElement(By.xpath("//div[contains(@data-module-name,'Stock')]"));
    stockDropDownElement.click();
    Thread.sleep(5000);
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
