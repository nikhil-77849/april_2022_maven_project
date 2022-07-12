package com.testology.tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtentDemoTest {
static ExtentTest test; // The instance of this class will help in Playing around the test case status/
static ExtentReports report;// The instance of this class will help in In configuration of test and report.
static ExtentSparkReporter spark;
@BeforeClass
public static void startTest()
{
report = new ExtentReports();

    spark = new ExtentSparkReporter("target/Spark.html");
    report.attachReporter(spark);
test = report.createTest("ExtentDemo");
}
@Test
public void extentReportsDemo_PositiveTest()
{
System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.google.co.in");
try {
    Assert.assertTrue(driver.getTitle().equals("Google"));
    test.log(Status.PASS, "Navigated to the specified URL");
}
catch(Exception e) {
    test.log(Status.FAIL, "Test Failed");
}
}


    @Test
    public void extentReportsDemo_NegativeTest()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        try {
            Assert.assertTrue(driver.getTitle().equals("Testology"));
            test.log(Status.PASS, "Navigated to the specified URL");
        }
        catch(Exception e) {
            test.log(Status.FAIL, "Test Failed");
        }
    }

@AfterClass
public static void endTest()
{
report.flush();
}
}
