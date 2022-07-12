package com.testology.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class ChromeAlertsTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void chromeAlertTest() throws InterruptedException {
        //URL launch
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // identify element
        WebElement popUpBtn=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        Thread.sleep(5000);
        popUpBtn.click();
        //shift to alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);
        //get alert text
        String s = alert.getText();
        System.out.println("Alert text is: " + s);
        //input text to alert
        alert.sendKeys("Selenium");
        // only in chrome browser the text entered may not be visible
        alert.accept();// clicking the ok button on the alert
        Thread.sleep(5000);
        popUpBtn.click();// opening the alert again to click the cancel button for demo
        //dismiss alert
        Thread.sleep(5000);
        alert.dismiss();//clicking the cancel button on alert
        Thread.sleep(5000);

    }// @test ends

    @AfterTest
    public void terminateDriver()
    {
        driver.close();// closing the current browser tab and window
        driver.quit();// Quiting the chrome browser process
    }

}
