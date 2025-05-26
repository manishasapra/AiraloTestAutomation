package com.airalo.web.core.base;

import com.airalo.common.config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.airalo.web.core.pages.EsimPopupPage;
import com.airalo.web.core.pages.HomePage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestWeb {

    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected EsimPopupPage esimPopupPage;


    public WebDriver getWebDriver(String browser) throws Exception {

        switch (browser.toLowerCase()) {

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "safari":
                driver = new SafariDriver();
                break;

            default:
                throw new Exception("Invalid platform! - " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) throws Exception {

        driver = getWebDriver(browser);
        driver.get(testConfig.websiteUrl());
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
