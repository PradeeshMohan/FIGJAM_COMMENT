package com.framework.lib.utils;

import java.io.IOException;


public class PropertyFileManager {

    private static final PropertyFileManager propertyFileManager = new PropertyFileManager();
    private static ConfigFileReader configFileReader;

    private PropertyFileManager() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PropertyFileManager getInstance() {
        return propertyFileManager;
    }

    /**
     * Gets config reader.
     *
     * @return the config reader
     */
    public ConfigFileReader getConfigReader() {
        try {
            return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}
