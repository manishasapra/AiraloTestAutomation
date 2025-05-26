package com.airalo.web.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This method is responsible for keeping locator and methods for Esim Popup Page.
 */
public class EsimPopupPage extends AbstractPage {

    //OR for Esim Popup Page
    @FindBy(css = "[data-testid='sim-detail-operator-title']")
    private WebElement operatorTitle;

    @FindBy(xpath = "//div[@data-testid='package-detail']//ul[@data-testid='sim-detail-info-list']//p[@data-testid='COVERAGE-value']")
    private WebElement coverageValue;

    @FindBy(xpath = "//div[@data-testid='package-detail']//ul[@data-testid='sim-detail-info-list']//p[@data-testid='DATA-value']")
    private WebElement dataValue;

    @FindBy(xpath = "//div[@data-testid='package-detail']//ul[@data-testid='sim-detail-info-list']//p[@data-testid='VALIDITY-value']")
    private WebElement validityValue;

    @FindBy(xpath = "//div[@data-testid='package-detail']//ul[@data-testid='sim-detail-info-list']//p[@data-testid='PRICE-value']")
    private WebElement priceValue;

    public EsimPopupPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is responsible for fetching operator details.
     *
     * @return
     */
    public String getOperatorTitle() {
        return waitAndReturnElementAvailable(operatorTitle).getText().trim();
    }

    /**
     * This method is responsible for fetching coverage value.
     *
     * @return
     */
    public String getCoverageValue() {
        return waitAndReturnElementAvailable(coverageValue).getText().trim();
    }

    /**
     * This method is responsible for fetching data value.
     *
     * @return
     */
    public String getDataValue() {
        return waitAndReturnElementAvailable(dataValue).getText().trim();
    }

    /**
     * This method is responsible for fetching validity value.
     *
     * @return
     */
    public String getValidityValue() {
        return waitAndReturnElementAvailable(validityValue).getText().trim();
    }

    /**
     * This method is responsible for fetching price value.
     *
     * @return
     */
    public String getPriceValue() {
        return waitAndReturnElementAvailable(priceValue).getText().trim();
    }
}
