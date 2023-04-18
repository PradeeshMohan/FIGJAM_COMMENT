package com.framework.lib.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ScreenShotAssistant {
    protected static final ConfigFileReader config = PropertyFileManager.getInstance().getConfigReader();
    protected static String screenShotDir = config.getProperty("screen-shot-dir");

    public static String getElementScreenShot(WebElement element) throws IOException {
        File srcFile = element.getScreenshotAs(OutputType.FILE);
        File trgFile = new File(screenShotDir + "\\canvasSS-"
                + getDate() + "_" + getTime() + ".png");
        FileUtils.copyFile(srcFile, trgFile);
        return trgFile.getName();

    }

    public static void takeScreenShot(WebDriver webDriver) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenShotDir + "\\fullPageSS-"
                + getDate() + "_" + getTime() + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }


    private static String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        return (df.format(new Date()));
    }

    private static String getTime() {
        DateFormat df = new SimpleDateFormat("hh-m-ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        return (df.format(new Date()));
    }

}
