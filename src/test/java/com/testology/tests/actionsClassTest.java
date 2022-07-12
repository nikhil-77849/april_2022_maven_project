package com.testology.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class actionsClassTest {
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
    public void iFrameTest() throws InterruptedException {

        driver.get("C:\\Users\\NiksuP\\Documents\\tutorials\\april_2022_maven_project\\src\\test\\resources\\doubleClick.html");

            WebElement btnElement= driver.findElement(By.xpath("//button[@id='btn']"));
            btnElement.click();// single click
            Thread.sleep(5000);
            Actions actions= new Actions(driver);
            actions.doubleClick(btnElement).build().perform(); //doubleclick
        actions.contextClick(btnElement).build().perform();
//scroll to top
        actions.scrollByAmount(0,2000).build().perform();
            Thread.sleep(5000);


    }


    @Test
    public void clickAndHoldAction() throws InterruptedException {
        driver.get("https://jqueryui.com/draggable/");
        WebElement dragFrame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));

        driver.switchTo().frame(0);
        WebElement dragBox = driver.findElement(By.id("draggable"));
        Thread.sleep(4000);
        Actions action = new Actions(driver);
        //
        action.clickAndHold(dragBox).moveByOffset(75, 75).build().perform();
        Thread.sleep(4000);

        driver.switchTo().parentFrame();
        File source = dragFrame.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "src/test/resources/screenshots/dragBox.png");

        try {
            FileHandler.copy(source, dest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void releaseAction() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));

        Thread.sleep(5000);
        Actions action = new Actions(driver);
        //Alternate way: action.clickAndHold(source).moveToElement(destination).release().build().perform();
        action.clickAndHold(source).release(destination).build().perform();
        Thread.sleep(5000);
        File src = destination.getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "src/test/resources/screenshots/release.png");

        try {
            FileHandler.copy(src, dest);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }



    @AfterTest
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }
}
