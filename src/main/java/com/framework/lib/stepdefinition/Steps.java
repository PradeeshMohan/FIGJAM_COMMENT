package com.framework.lib.stepdefinition;

import com.framework.lib.utils.Log;
import com.framework.lib.utils.PropertyFileManager;
import com.framework.lib.utils.TestContext;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;


public abstract class Steps {
    protected WebDriver webDriver;
    protected String scenarioName = "";
    protected boolean scenarioStartMsgPrinted = false;
    private boolean envMsgPrinted = false;
    protected TestContext context;
    protected Properties properties;

    /**
     * Steps Constructor
     *
     * @throws IOException the io exception
     */
    public Steps() throws IOException {
        context = new TestContext();

        properties = PropertyFileManager.getInstance().getConfigReader().getConfigProperties();

        System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s %n");

        // print to the Console what environment is under test
        if (!envMsgPrinted) {
            Properties environmentProperties = PropertyFileManager.getInstance().getConfigReader().getEnvironmentProperties();
            Log.info("------------------------------------------------------------------------------------------------------------------------------");
            Log.info("ENVIRONMENT UNDER TEST: " + environmentProperties.getProperty("environment"));
            envMsgPrinted = true;
        }
    }

    /**
     * logScenario - Log the scenario name
     *
     * @param scenario - contains the name and status of the Scenario
     */
    protected void logScenario(Scenario scenario) {

        scenarioName = scenario.getName();
        if (!scenarioStartMsgPrinted) {
            Log.info("Scenario: " + scenarioName + " - IN PROGRESS");
            scenarioStartMsgPrinted = true;
        }
    }

    /**
     * tearDown -  TearDown / After Scenario method
     *
     * @param scenario - contains the name and status of the Scenario
     * @throws Exception - exception
     */
    protected void tearDown(Scenario scenario) throws Exception {

        if (!scenarioName.equalsIgnoreCase(scenario.getName()) || scenarioStartMsgPrinted) {
            Log.info("# Scenario: " + scenario.getName() + " - " + scenario.getStatus());
            Log.info("------------------------------------------------------------------------------------------------------------------------------\n");

            scenarioName = scenario.getName();
            scenarioStartMsgPrinted = false;
        }

        // if there is a WebDriver open, close it
       if (webDriver != null) {
           context.getWebDriverFactory().closeDriver();
            webDriver = null;
        }
    }

    public void sleepThread(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
