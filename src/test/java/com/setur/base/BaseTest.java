package com.setur.base;

import com.setur.util.ConstantsValues;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;
    public static ChromeOptions chromeOptions = new ChromeOptions();

    @Before
    public void setUp() {
        chromeOp(chromeOptions);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(ConstantsValues.HOME_PAGE);
    }


    public static void chromeOp(ChromeOptions chromeOptions) {
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.addArguments("--remote-allow-origins=*");
    }


    @After
    public void tearDown() throws InterruptedException {
     //   wait(8000);
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
