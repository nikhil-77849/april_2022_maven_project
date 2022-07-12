package com.testology.tests;
import com.google.common.util.concurrent.Uninterruptibles;
import com.sun.xml.messaging.saaj.util.Base64;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class AuthTest {
    @Test
            public void authTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools dev = driver.getDevTools();
        dev.createSession();
        dev.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        // We are creating a header Map of Key Value Pairs
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Basic " + new String(Base64.encode("admin:admin".getBytes())));
//printing the base64 encoded string
        System.out.println("Basic " + new String(Base64.encode("admin:admin".getBytes())));
        dev.send(Network.setExtraHTTPHeaders(new Headers(headerMap)));
Thread.sleep(5000);
        driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
        driver.close();
        driver.quit();
    }
}