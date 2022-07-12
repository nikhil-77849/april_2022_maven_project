package com.testology.tests;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class Popup_Demo { 
public static void main(String[] args) throws InterruptedException, AWTException {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("file:///C:/Users/NiksuP/Documents/tutorials/March2022Batch_Java_Selenium/alert.html");
Thread.sleep(5000);
driver.findElement(By.id("PopUp")).click(); // Clicking on the popup button
Robot robot = new Robot();
//robot.mouseMove(400.5); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
Thread.sleep(2000);
robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
Thread.sleep(2000);
driver.quit();
}
}
