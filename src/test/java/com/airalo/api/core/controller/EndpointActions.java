package com.airalo.api.core.controller;

import com.airalo.api.core.base.BaseTestApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * This method is responsible for calling all Airalo endpoints.
 */
public class EndpointActions extends BaseTestApi {

    /**
     * This method is responsible for creating orders on Airalo.
     *
     * @param createOrderParams
     * @return
     */
    public Response createOrder(Map<String, String> createOrderParams) {
        return given()
                .contentType(ContentType.URLENC)
                .auth()
                .oauth2(getCredentials())
                .formParams(createOrderParams)
                .when()
                .post(ControllerConstants.CREATE_ORDER_ENDPOINT)
                .then().log().all()
                .extract()
                .response();
    }

    /**
     * This method is responsible for fetching Airalo order list.
     *
     * @return
     */
    public Response listSimsOrders() {
        return given()
                .auth()
                .oauth2(getCredentials())
                .when()
                .get(ControllerConstants.GET_E_SIMS_LIST)
                .then().log().all()
                .extract()
                .response();
    }

    /**
     * This method is responsible for generating bearer token.
     *
     * @return
     */
    public String getCredentials() {
        Map<String, String> authParams = new HashMap<>();
        authParams.put("client_id", System.getenv("CLIENT_KEY"));
        authParams.put("client_secret", System.getenv("CLIENT_SECRET"));
        authParams.put("grant_type", "client_credentials");

        return given()
                .contentType(ContentType.URLENC)
                .when()
                .formParams(authParams)
                .post(ControllerConstants.GENERATE_CREDS_ENDPOINT)
                .then().log().all()
                .extract()
                .response().jsonPath().getString("data.access_token");
    }
}
