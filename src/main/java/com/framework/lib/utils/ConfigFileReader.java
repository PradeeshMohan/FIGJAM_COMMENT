package com.framework.lib.utils;

import com.framework.lib.enums.BROWSER_TYPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


public class ConfigFileReader {

    private static final String environmentFilePath = "src/test/resources/properties/environment.properties";
    private static final String configFilePath = "src/test/resources/properties/config.properties";
    private Properties environmentProperties;
    private Properties configProperties;


    /**
     * Constructor
     *
     * @throws IOException the io exception
     */
    public ConfigFileReader() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(environmentFilePath));
            environmentProperties = new Properties();
            environmentProperties.load(reader);
            reader.close();

            reader = new BufferedReader(new FileReader(configFilePath));
            configProperties = new Properties();
            configProperties.load(reader);
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * getConfigProperties - get the properties from the config file
     *
     * @return Configuration Property Object
     */
    public Properties getConfigProperties() {
        return configProperties;
    }


    /**
     * getEnvironmentProperties - get the properties from the environment file
     *
     * @return Environment property
     */
    public Properties getEnvironmentProperties() {
        return environmentProperties;
    }


    /**
     * getImplicitlyWait - get the timeout from config file
     *
     * @return implicit timeout specified in config file
     */
    public long getImplicitlyWait() {
        String implicitlyWait = configProperties.getProperty("implicitlyWait");

        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Unable to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 0;
    }

    public BROWSER_TYPE getBrowserType() {

        String browserProp = System.getProperty("browserUnderTest");
        String browserName = "";
        try {
            if (browserProp.equalsIgnoreCase("chrome")
                    || browserProp.equalsIgnoreCase("safari")
                    || browserProp.equalsIgnoreCase("firefox")
                    || browserProp.equalsIgnoreCase("internet_explorer")
                    || browserProp.equalsIgnoreCase("edge")) {
                browserName = browserProp;
            } else {
                browserName = configProperties.getProperty("browser-type");
            }
        } catch (Exception e) {
            browserName = configProperties.getProperty("browser-type");
        }

        if (Objects.equals(browserName, "") || browserName.equalsIgnoreCase("chrome")) {
            return BROWSER_TYPE.CHROME;
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return BROWSER_TYPE.FIREFOX;
        } else if (browserName.equalsIgnoreCase("safari")) {
            return BROWSER_TYPE.SAFARI;
        } else if (browserName.equalsIgnoreCase("internet_explorer")) {
            return BROWSER_TYPE.INTERNET_EXPLORER;
        } else if (browserName.equalsIgnoreCase("edge")) {
            return BROWSER_TYPE.EDGE;
        } else {
            throw new RuntimeException("Browser in config file is not supported!!!");
        }
    }

    /**
     * getProperty - get any property from config file
     *
     * @param property - property name
     * @return property value as String
     */
    public String getProperty(String property) {
        String propertyValue = configProperties.getProperty(property);

        if (propertyValue != null) {
            return propertyValue;
        } else {
            throw new RuntimeException(property + " was not defined in the config.properties file");
        }
    }

}
