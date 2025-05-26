package com.airalo.api.scenarios;

import com.airalo.api.core.base.BaseTestApi;
import com.airalo.api.core.controller.EndpointActions;
import com.airalo.common.dataprovider.SimsOrderTestDataProvider;
import com.airalo.api.core.helper.TestHelper;
import com.airalo.api.core.models.EsimData;
import com.airalo.api.core.models.EsimListResponse;
import com.airalo.api.core.models.EsimOrderResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class AiraloApiTests extends BaseTestApi {

    EndpointActions endpointActions = new EndpointActions();
    TestHelper testHelper = new TestHelper();

    @Test(dataProvider = "createOrderDataProvider", dataProviderClass = SimsOrderTestDataProvider.class)
    public void validateSimsOrder(Map<String, String> createOrderData, EsimOrderResponse esimOrderExpectedResponse, ITestContext context) {

        log.infoMSG("Creating sim order with : " + createOrderData);
        Response response = endpointActions.createOrder(createOrderData);
        EsimOrderResponse esimOrderActualResponse = response.as(EsimOrderResponse.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + esimOrderExpectedResponse);
        //Validating most of the fields and removing dynamic data to validate in next call
        Assertions.assertThat(esimOrderActualResponse).usingRecursiveComparison()
                .ignoringFields(
                        "data.id",
                        "data.code",
                        "data.createdAt",
                        "data.sims.id",
                        "data.sims.createdAt",
                        "data.sims.iccId",
                        "data.sims.qrCodeUrl"
                ).isEqualTo(esimOrderExpectedResponse);

        context.setAttribute("esimOrderResponse", esimOrderActualResponse);
    }

    @Test(dependsOnMethods = "validateSimsOrder", dataProvider = "listOrderDataProvider", dataProviderClass = SimsOrderTestDataProvider.class)
    public void validateSimsInList(List<EsimData> esimListExpectedResponse, ITestContext context) {

        EsimOrderResponse esimOrderResponse = (EsimOrderResponse) context.getAttribute("esimOrderResponse");

        Response response = endpointActions.listSimsOrders();
        EsimListResponse esimListResponse = response.as(EsimListResponse.class);

        log.infoMSG("Validating status code to be : " + HttpStatus.SC_OK);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        log.infoMSG("Validating response payload to be : " + esimListExpectedResponse);
        Assertions.assertThat(new HashSet<>(testHelper.getOrderListActualResponse(esimOrderResponse, esimListResponse)))
                .usingRecursiveComparison()
                .isEqualTo(new HashSet<>(testHelper.getOrderListExpectedResponse(esimOrderResponse, esimListExpectedResponse)));
    }
}
