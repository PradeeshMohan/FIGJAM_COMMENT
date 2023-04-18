package com.framework.lib.utils;

import com.framework.lib.enums.BROWSER_TYPE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebDriverFactory {


    private static final BROWSER_TYPE WEB_BROWSER_TYPE =
            PropertyFileManager.getInstance().getConfigReader().getBrowserType();

    private WebDriver webDriver;
    boolean headless;

    private boolean getHeadlessMode() {
        if (System.getProperty("headlessMode") != null) {

            headless = Boolean.parseBoolean(System.getProperty("headlessMode"));
        } else {
            headless = Boolean.parseBoolean(PropertyFileManager.getInstance().getConfigReader().getProperty("browser-headless"));
        }
        return headless;
    }


    /**
     * Get the current instance of the webDriver singleton.
     * If one does not already exist, create it.
     *
     * @return WebDriver - The WebDriver
     */
    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = createWebDriver();
        }
        return webDriver;
    }


    /**
     * Create a Web Driver for a specified Browser Type. Current options are: Chrome, Firefox, Safari, Internet_Explorer
     *
     * @return WebDriver - The WebDriver
     */
    private WebDriver createWebDriver() {
        switch (WEB_BROWSER_TYPE) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.setHeadless(getHeadlessMode());
                webDriver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
            case INTERNET_EXPLORER:
                webDriver = new InternetExplorerDriver();
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setHeadless(getHeadlessMode());
                webDriver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalStateException(String.format("The device type %s is invalid!", WEB_BROWSER_TYPE));
        }

        return webDriver;
    }

    public void closeDriver() {
       if (webDriver != null) {
            webDriver.quit();
}
    }

}
