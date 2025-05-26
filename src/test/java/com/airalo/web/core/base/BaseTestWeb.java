package com.airalo.web.core.base;

import com.airalo.common.config.TestConfig;
import com.airalo.common.utils.LoggerUtility;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
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

/**
 * This class contains common information for Web tests.
 */
public class BaseTestWeb {

    protected final LoggerUtility log = new LoggerUtility(LogManager.getLogger(getClass()));
    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected EsimPopupPage esimPopupPage;


    /**
     * This method is responsible for fetching correct webdriver.
     *
     * @param browser
     * @return
     * @throws Exception
     */
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

    /**
     * This method is responsible for setting up browser before tests.
     *
     * @param browser
     * @throws Exception
     */
    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) throws Exception {

        driver = getWebDriver(browser);
        driver.get(testConfig.websiteUrl());
        homePage = new HomePage(driver);
    }

    /**
     * This method is responsible for ending browser session after tests.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
