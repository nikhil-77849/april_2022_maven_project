package com.testology.tests;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindowTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testWindows() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

        WebElement followOnTwitter = driver.findElement(By.xpath("//a[text()='  Follow On Twitter ']"));
        followOnTwitter.click();// this should open a new window on the screen
        // To handle parent window
        String MainWindow = driver.getWindowHandle();// getting the reference of main window
        System.out.println("Main window handle is " + MainWindow);
        // To handle child window
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Child window handle is" + windowHandles);

        Iterator<String> itrator = windowHandles.iterator();


        while (itrator.hasNext()) {
            String ChildWindow = itrator.next();// storing the reference of child window
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                Thread.sleep(5000);
                driver.switchTo().window(ChildWindow);
                String pageTitle = driver.getTitle();
                System.out.println("The web page title of child window is:" + pageTitle);
                //if child window title gets printed the we have successfully switched to child window.
                driver.close();
                System.out.println("Child window closed");
            }
        }

Thread.sleep(5000);
        driver.switchTo().window(MainWindow);

    }

    @AfterTest
    public void terminateDriver() {
        driver.close();
        driver.quit();
    }

}