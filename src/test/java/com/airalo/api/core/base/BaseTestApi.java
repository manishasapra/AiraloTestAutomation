package com.airalo.api.core.base;

import com.airalo.common.config.TestConfig;
import com.airalo.common.utils.LoggerUtility;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;

/**
 * This class is responsible for keeping common information across complete framework.
 */
public class BaseTestApi {

    protected final LoggerUtility log = new LoggerUtility(LogManager.getLogger(getClass()));
    protected final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    /**
     * This method is responsible for setting up uri before test cases.
     */
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = testConfig.apiBaseUrl();
    }
}
