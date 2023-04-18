package com.framework.lib.utils;

import java.io.IOException;
import java.util.UUID;

public class TestContext {


    private final String testID;
    private final WebDriverFactory webDriverFactory;

    /**
     * Instantiates a new Test context.
     *
     * @throws IOException the io exception
     */
    public TestContext() throws IOException {
        webDriverFactory = new WebDriverFactory();
        testID = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }


    /**
     * Gets web driver factory.
     *
     * @return the Web driver factory
     */
    public WebDriverFactory getWebDriverFactory() {
        return webDriverFactory;
    }


    public final String getTestID() {
        return this.testID;
    }
}
