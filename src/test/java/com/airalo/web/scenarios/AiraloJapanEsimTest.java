package com.airalo.web.scenarios;

import com.airalo.common.dataprovider.SimsOrderTestDataProvider;
import com.airalo.web.core.base.BaseTestWeb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AiraloJapanEsimTest extends BaseTestWeb {

    @Test(dataProvider = "japanEsimDetails", dataProviderClass = SimsOrderTestDataProvider.class)
    public void verifyJapanEsimDetails(String operatorTitle, String coverage, String data, String validity, String price) {
        log.infoMSG("Searching location : " + coverage);
        homePage.searchAndSelectOption(coverage);
        log.infoMSG("Selecting buy package");
        esimPopupPage = homePage.buyPackage();

        log.infoMSG("Validating title to be : " + operatorTitle);
        Assert.assertEquals(esimPopupPage.getOperatorTitle(), operatorTitle);
        log.infoMSG("Validating coverage to be : " + coverage);
        Assert.assertEquals(esimPopupPage.getCoverageValue(), coverage);
        log.infoMSG("Validating data to be : " + data);
        Assert.assertEquals(esimPopupPage.getDataValue(), data);
        log.infoMSG("Validating validity to be : " + validity);
        Assert.assertEquals(esimPopupPage.getValidityValue(), validity);
        log.infoMSG("Validating price to be : " + price);
        Assert.assertEquals(esimPopupPage.getPriceValue(), price);
    }
}
