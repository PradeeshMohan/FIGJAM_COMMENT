package com.framework.lib.utils;

import com.framework.lib.enums.DESKTOP_TYPE;

public class TestHost {
    public static DESKTOP_TYPE getTestHostType() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("window")) {
            return DESKTOP_TYPE.WINDOWS;
        } else if (osName.contains("mac")) {
            return DESKTOP_TYPE.MAC;
        }
        return DESKTOP_TYPE.UNKNOWN;
    }

}
