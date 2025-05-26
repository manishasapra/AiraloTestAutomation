package com.airalo.common.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

/**
 * The class is responsible for keeping config information.
 */
@LoadPolicy(LoadType.MERGE)
@Sources("classpath:env.properties")
public interface TestConfig extends Config {

    @Key("websiteUrl")
    String websiteUrl();

    @Key("longWait")
    int longWait();

    @Key("apiBaseUrl")
    String apiBaseUrl();
}