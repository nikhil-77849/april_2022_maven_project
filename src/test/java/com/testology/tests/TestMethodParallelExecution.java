package com.testology.tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class TestMethodParallelExecution {
 

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

    }
 
@Test
public void loginTest() {
        WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    // To navigate to URL
  driver.get("https://opensource-demo.orangehrmlive.com/");
  // To locate input field for username and enter value
  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
  // To locate input field for password and enter value
  driver.findElement(By.name("txtPassword")).sendKeys("admin123");
  // To locate and click on login button
   driver.findElement(By.className("button")).click();
    driver.close();// closing the current browser tab and window
    driver.quit();// Quiting the chrome browser process

    }
 
  @Test
  public void forgotPasswordTest() throws InterruptedException {
 WebDriver driver ;

      driver = new ChromeDriver();
      driver.manage().window().maximize();

      // To navigate to URL
    driver.get("https://opensource-demo.orangehrmlive.com/");
    try {
        if (driver.findElement(By.linkText("¿Olvidó su contraseña?")).isDisplayed()) {
            // To locate and click on Forgot password link
            driver.findElement(By.linkText("¿Olvidó su contraseña?")).click();
        }
    }
    catch (Exception e) {
        if (driver.findElement(By.linkText("Forgot your password?")).isDisplayed()) {
            // To locate and click on Forgot password link
            driver.findElement(By.linkText("Forgot your password?")).click();
        }
    }
Thread.sleep(5000);
    // To locate input field and enter username
    driver.findElement(By.id("securityAuthentication_userName")).sendKeys("testuser");
    // To locate and click on reset button
    driver.findElement(By.id("btnSearchValues")).click();
      driver.close();// closing the current browser tab and window
      driver.quit();// Quiting the chrome browser process

  }


}