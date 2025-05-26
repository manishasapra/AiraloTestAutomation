package com.airalo.api.core.base;

import com.airalo.common.config.TestConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;

public class BaseTestApi {

    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = testConfig.apiBaseUrl();
    }
}
