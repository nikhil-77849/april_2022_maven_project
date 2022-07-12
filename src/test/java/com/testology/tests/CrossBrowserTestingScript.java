package com.testology.tests;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestingScript {
WebDriver driver=null;
/**
* This function will execute before each Test tag in testng.xml
* @param browser
* @throws Exception
*/
@BeforeTest
@Parameters("browser")
public void setup(String browser) throws Exception{
//Check if parameter passed from TestNG is 'firefox'
if(browser.equalsIgnoreCase("firefox")){
//create firefox instance
System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
driver = new FirefoxDriver();
}
//Check if parameter passed as 'chrome'
else if(browser.equalsIgnoreCase("chrome")){
//set path to chromedriver.exe
System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
driver = new ChromeDriver();
}
else if(browser.equalsIgnoreCase("Edge")){
//set path to Edge.exe
System.setProperty("webdriver.edge.driver","src/test/resources/drivers/msedgedriver.exe");
driver = new EdgeDriver();
}
else{
//If no browser is passed throw exception
throw new Exception("Incorrect Browser");
}
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@Test
public void crossBrowserTest() throws InterruptedException{
    driver.get("https://test.techlift.in/login#login");
    Thread.sleep(5000);
    WebElement email=driver.findElement(By.xpath("//input[@id='login_email']"));

    WebElement password=driver.findElement(By.xpath("//input[@id='login_password']"));

    WebElement loginBtn=driver.findElement(By.xpath("//button[contains(@class,'btn-login')]"));
    email.sendKeys("testology.qa.learning@gmail.com");
    password.sendKeys("Testology@123");
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
        if(driver!=null)
        driver.close();
        driver.quit();
    }

}