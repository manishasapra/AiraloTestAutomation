package com.airalo.web.scenarios;

import com.airalo.common.dataprovider.SimsOrderTestDataProvider;
import com.airalo.web.core.base.BaseTestWeb;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AiraloJapanEsimTest extends BaseTestWeb {

    @Test(dataProvider = "japanEsimDetails", dataProviderClass = SimsOrderTestDataProvider.class)
    public void verifyJapanEsimDetails(String operatorTitle, String coverage, String data, String validity, String price) {
        homePage.searchAndSelectOption();
        esimPopupPage = homePage.buyPackage();

        Assert.assertEquals(esimPopupPage.getOperatorTitle(), operatorTitle);
        Assert.assertEquals(esimPopupPage.getCoverageValue(), coverage);
        Assert.assertEquals(esimPopupPage.getDataValue(), data);
        Assert.assertEquals(esimPopupPage.getValidityValue(), validity);
        Assert.assertEquals(esimPopupPage.getPriceValue(), price);
    }

}
