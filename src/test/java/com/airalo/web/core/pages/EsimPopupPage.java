package com.airalo.web.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EsimPopupPage extends AbstractPage {

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

    public String getOperatorTitle() {
        return waitAndReturnElementAvailable(operatorTitle).getText().trim();
    }

    public String getCoverageValue() {
        return waitAndReturnElementAvailable(coverageValue).getText().trim();
    }

    public String getDataValue() {
        return waitAndReturnElementAvailable(dataValue).getText().trim();
    }

    public String getValidityValue() {
        return waitAndReturnElementAvailable(validityValue).getText().trim();
    }

    public String getPriceValue() {
        return waitAndReturnElementAvailable(priceValue).getText().trim();
    }
}
