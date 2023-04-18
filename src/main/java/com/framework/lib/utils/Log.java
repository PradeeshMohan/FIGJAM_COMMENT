package com.framework.lib.utils;

import java.util.logging.Logger;


public class Log {

    private final static Logger LOGGER = Logger.getLogger(Log.class.getName());

    /**
     * Config.
     *
     * @param msg the msg
     */
    public static void config(String msg) {
        LOGGER.config(msg);
    }

    /**
     * Fine.
     *
     * @param msg the msg
     */
    public static void fine(String msg) {
        LOGGER.fine(msg);
    }

    /**
     * Finer.
     *
     * @param msg the msg
     */
    public static void finer(String msg) {
        LOGGER.finer(msg);
    }

    /**
     * Finest.
     *
     * @param msg the msg
     */
    public static void finest(String msg) {
        LOGGER.finest(msg);
    }

    /**
     * Info.
     *
     * @param msg the msg
     */
    public static void info(String msg) {
        LOGGER.info(msg);
    }

    /**
     * Severe.
     *
     * @param msg the msg
     */
    public static void severe(String msg) {
        LOGGER.severe(msg);
    }

    /**
     * Warning.
     *
     * @param msg the msg
     */
    public static void warning(String msg) {
        LOGGER.warning(msg);
    }

}

