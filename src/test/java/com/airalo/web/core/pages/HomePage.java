package com.airalo.web.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    //OR for Home Page.
    @FindBy(css = "[data-testid='search-input']")
    private WebElement searchBox;

    @FindBy(css = "[data-testid='Japan-name']")
    private WebElement japanListOption;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(css = ".No.thanks")
    private WebElement rejectNotification;

    @FindBy(xpath = "(//*[@data-testid='esim-button'])[2]")
    private WebElement buyNow;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchAndSelectOption() {
        waitAndReturnElementClickable(acceptCookies).click();
        waitAndReturnElementClickable(rejectNotification).click();
        waitAndReturnElementClickable(searchBox).sendKeys("Japan");
        waitAndReturnElementClickable(japanListOption).click();
    }

    public EsimPopupPage buyPackage() {
        waitAndReturnElementClickable(buyNow).click();
        return new EsimPopupPage(driver);
    }
}
