package com.testology.tests;

import com.testology.pages.Testology;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class iFrameTest {
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

        driver.get("C:\\Users\\NiksuP\\Documents\\tutorials\\april_2022_maven_project\\src\\test\\resources\\iframe.html");
        //Count the IFrames Available on Screen
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));

        if(iframeElements.size()>0)
        {
            System.out.println("Total number of iframes are " + iframeElements.size());
            Thread.sleep(10000);
            driver.switchTo().frame("iframe1");// switching to iframe1
           WebElement element= driver.findElement(By.xpath("//button[@class='menu-toggle']"));
           element.click();
            driver.switchTo().defaultContent();//switching back to default dom context

            WebElement btnElement= driver.findElement(By.xpath("//button[@id='btn']"));
            btnElement.click();

            WebElement iframe2Element= driver.findElement(By.xpath("//iframe[@id='IF2']"));
            driver.switchTo().frame(iframe2Element);

             element= driver.findElement(By.xpath("//button[@class='menu-toggle']"));
            element.click();
driver.switchTo().defaultContent();

            driver.navigate().refresh();


            Thread.sleep(3000);

            btnElement= driver.findElement(By.xpath("//button[@id='btn']"));
            btnElement.click();

            Thread.sleep(3000);

        }
    }
    @AfterTest
    public void afterTest()
    {
        driver.close();
        driver.quit();
    }
}
