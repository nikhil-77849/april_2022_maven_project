package com.testology.tests;// The sample test script in this section is compatible with JSON wire protocol-based
// client bindings. Check out our W3C-based scripts in 
// the selenium-4 branch of the same repository.
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteFireFoxTest {
  public static final String AUTOMATE_USERNAME = "nikhiltestology_vkDBil";
  public static final String AUTOMATE_ACCESS_KEY = "3Y2HjBngESuTQL8cqarY";
  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

  @Test
  public void fireFoxBrowserStackTest ()throws Exception {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("os_version", "10");
    caps.setCapability("resolution", "1920x1080");
    caps.setCapability("browser", "Firefox");
    caps.setCapability("browser_version", "latest");
    caps.setCapability("os", "Windows");
    caps.setCapability("name", "fireFoxBrowserStackTest"); // test name
    //caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
    final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    try {
      driver.get("https://test.techlift.in/login#login");
      Thread.sleep(5000);
      WebElement email = driver.findElement(By.xpath("//input[@id='login_email']"));

      WebElement password = driver.findElement(By.xpath("//input[@id='login_password']"));

      WebElement loginBtn = driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
      email.sendKeys("testology.qa.learning@gmail.com");
      password.sendKeys("Testology@123");
      loginBtn.click();
      Thread.sleep(5000);
      WebElement settingsDropDown = driver.findElement(By.xpath("//a//span[contains(text(),'Settings')]"));
      Assert.assertTrue(settingsDropDown.isDisplayed());// assertion to check whether the settings dropdown is displayed
      // if this assertion passes then we are successfully logged in to test.techlift.in

      WebElement stockDropDownElement = driver.findElement(By.xpath("//div[contains(@data-module-name,'Stock')]"));
      stockDropDownElement.click();
      Thread.sleep(5000);
      WebElement stockPageTitle = driver.findElement(By.xpath("//div[contains(@class,'title') and text()='Stock']"));
      Assert.assertTrue(stockPageTitle.isDisplayed());// assertion to check whether the settings dropdown is displayed
      driver.quit();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  /*// This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
  public static void markTestStatus(String status, String reason, WebDriver driver) {
    final JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ status + "\", \"reason\": \"" + reason + "\"}}");
  }*/
} 