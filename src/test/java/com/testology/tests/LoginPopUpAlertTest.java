package com.testology.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPopUpAlertTest {


    WebDriver driver ;

    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void loginPopUpTest() throws InterruptedException {

        //Set the username
    String username = "admin";

    //Set the password
    String password = "admin";


    //String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
        String URL = "https://" + "the-internet.herokuapp.com/basic_auth";

			driver.get(URL);
Thread.sleep(5000);
			//Wait and Time out for PageLoad
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    String title = driver.getTitle();

			System.out.println("The page title is "+title);

    String text = driver.findElement(By.tagName("p")).getText();

			System.out.println("The text present in page is ==> "+text);

    }
    @AfterTest
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }


}
