package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @BeforeSuite
    void beforeEveryThingStart() {
        System.out.println("Starting the test Suite");
    }


    @AfterSuite
    public void afterEveryThingEnds() {
        System.out.println("Shutting down");
    }

    public WebDriver getDriver()
    {
        return new ChromeDriver();
    }

}
