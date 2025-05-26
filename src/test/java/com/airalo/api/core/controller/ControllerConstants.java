package com.airalo.api.core.controller;

public class ControllerConstants {

    public static String CREATE_ORDER_ENDPOINT = "/orders";
    public static String GENERATE_CREDS_ENDPOINT = "/token";

    public static String GET_E_SIMS_LIST = "/sims?include=order,order.status,order.user&limit=10&page=1";
}
