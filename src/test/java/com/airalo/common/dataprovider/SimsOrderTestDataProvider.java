package com.airalo.common.dataprovider;

import com.airalo.api.core.models.EsimData;
import com.airalo.api.core.models.EsimOrderResponse;
import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a common data provider class.
 */
public class SimsOrderTestDataProvider {

    /**
     * This method is responsible for keeping data of create order.
     *
     * @return
     * @throws FileNotFoundException
     */
    @DataProvider(name = "createOrderDataProvider")
    public static Object[][] createOrderData() throws FileNotFoundException {
        Map<String, String> createOrderFormData = new LinkedHashMap<>();
        createOrderFormData.put("quantity", "6");
        createOrderFormData.put("package_id", "merhaba-7days-1gb");
        createOrderFormData.put("type", "sim");

        EsimOrderResponse esimOrderResponse = new Gson().fromJson(
                new FileReader("src/test/resources/testdata/createOrderResponseData.json"), EsimOrderResponse.class);

        return new Object[][] {
                { createOrderFormData, esimOrderResponse }
        };
    }

    /**
     * This method is responsible for keeping data of list orders.
     *
     * @return
     * @throws FileNotFoundException
     */
    @DataProvider(name = "listOrderDataProvider")
    public static Object[][] listOrderData() throws FileNotFoundException {
        Type esimListType = new TypeToken<List<EsimData>>() {}.getType();
        List<EsimData> esimListResponse = new Gson().fromJson(
                new FileReader("src/test/resources/testdata/listSimResponseOrderData.json"), esimListType);

        return new Object[][] {
                { esimListResponse }
        };
    }

    /**
     * This method is responsible for keeping data of web app tests.
     *
     * @return
     */
    @DataProvider(name = "japanEsimDetails")
    public Object[][] provideJapanEsimDetails() {
        return new Object[][]{
                { "Moshi Moshi", "Japan", "1 GB", "7 Days", "4.50 €" }
        };
    }
}