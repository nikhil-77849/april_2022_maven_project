package com.testology.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.TestBase;

public class LoginLogOutTest_Data_Provider  extends TestBase {
    WebDriver driver;

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("I am inside before Test annotation method");
    }

    @BeforeMethod
    public void setUp()
    {
        System.out.println("I am inside before Method annotation method");
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider="logInData")
    public void verify_user_is_not_able_to_login_with_InValid_credentials(String userNameVal,String passwordVal) throws InterruptedException {
        System.out.println("I am inside the test case with @test annotation at line 30");
     /*   driver.get("https://test.techlift.in/login#login");
        Thread.sleep(5000);
        WebElement email=driver.findElement(By.xpath("//input[@id='login_email']"));

        WebElement password=driver.findElement(By.xpath("//input[@id='login_password']"));

        WebElement loginBtn=driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
        email.sendKeys(userNameVal);
        password.sendKeys(passwordVal);
        loginBtn.click();
        Thread.sleep(5000);

        WebElement invalid_Login_Message;

        if(userNameVal.contains(" "))
        {
            invalid_Login_Message= driver.findElement(By.xpath("//div[contains(text(),'Both login and password required')]"));
            WebElement crossButton=driver.findElement(By.xpath("//button[contains(@class,'close')]//span"));
            Assert.assertTrue(invalid_Login_Message.isDisplayed());// assertion to check whether the settings dropdown is displayed
            crossButton.click();
            //Verify the invalid login message pop should get dis-appeared

            Assert.assertTrue(!invalid_Login_Message.isDisplayed());
        }
        else {
            invalid_Login_Message= driver.findElement(By.xpath("//span[contains(text(),'Invalid Login. Try again')]"));
            Assert.assertTrue(invalid_Login_Message.isDisplayed());// assertion to check whether the settings dropdown is displayed
        }
        Thread.sleep(5000);
     */   // if this assertion passes then we are successfully logged in to test.techlift.in
    }


    @DataProvider
    public Object [] [] logInData ()
    {
        Object [] [] data = new Object [3] [2];

        data [0] [0] = "testology.qa.learning@gmail.com";    data [0] [1] = "testology@123";
        data [1] [0] = "nikilchandwani@outlook.com";      data [1] [1] = "Testology@123";
        data [2] [0] = " ";      data [2] [1] = " ";

        return data;
    }



    @AfterMethod
    public void terminateDriver()
    {
        System.out.println("I am inside after method annotation method i.e terminateDriver");
        driver.close();
        driver.quit();
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("I am inside after test annotation method");
    }

}
