package com.testology.tests;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MultiTabTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tabsTest() throws InterruptedException {
        driver.get("https://test.techlift.in/");

        // Keys.Chord string
        String clickl = Keys.chord(Keys.CONTROL, Keys.ENTER);
        // open the link in new tab, Keys.Chord string passed to sendKeys
        driver.findElement(
                By.xpath("//a[text()='Explore']")).sendKeys(clickl);
        Thread.sleep(5000);
        // hold all window handles in array list
        ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabsList.get(1));// tabsList can also become window list
        System.out.println("printing title of new tab");
        System.out.println("Page title of new tab: " + driver.getTitle());// printing title of new tab
        //switch to parent tab
        Thread.sleep(4000);
        driver.switchTo().window(tabsList.get(0));
        System.out.println("printing title of parent tab");
        System.out.println("Page title of parent window: " + driver.getTitle());

        Thread.sleep(4000);
        //switch to new tab
        driver.switchTo().window(tabsList.get(1));
        driver.close();// this command closes the new tab
        Thread.sleep(4000);
        driver.switchTo().window(tabsList.get(0));// switching back to original tab

    }// @test ends

    @AfterTest
    public void terminateDriver()
    {
        driver.close();// closing the current browser tab and window
        driver.quit();// Quiting the chrome browser process
    }

}
