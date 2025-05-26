package com.airalo.web.core.pages;

import com.airalo.web.core.base.BaseTestWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This is a base class keeping common data for all pages.
 */
public class AbstractPage extends BaseTestWeb {

    public AbstractPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(testConfig.longWait()));
    }

    /**
     * This method is responsible for waiting for an element to be available.
     *
     * @param elementToWait
     * @return
     */
    protected WebElement waitAndReturnElementAvailable(WebElement elementToWait) {
        return wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    /**
     * This method is responsible for waiting for an element to be clickable.
     *
     * @param elementToWait
     * @return
     */
    protected WebElement waitAndReturnElementClickable(WebElement elementToWait) {
        return wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
    }
}
