package com.testology.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class FireFoxAlertsTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tabsTest() throws InterruptedException {
        //URL launch
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // identify element
        WebElement promptButton=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        promptButton.click();
        Thread.sleep(5000);
        //shift to alert
        Alert alertBox = driver.switchTo().alert();
        //get alert text
        String s = alertBox.getText();
        System.out.println("Alert text is: " + s);
        //input text to alert
        alertBox.sendKeys("Selenium");
        Thread.sleep(5000);
        //accept alert
        alertBox.accept();
        Thread.sleep(5000);
        promptButton.click();
        Thread.sleep(5000);
        //dismiss alert
        alertBox.dismiss();
        Thread.sleep(5000);
    }// @test ends

    @AfterTest
    public void terminateDriver()
    {
        driver.switchTo().defaultContent();
        driver.close();// closing the current browser tab and window
        driver.quit();// Quiting the chrome browser process
    }

}
