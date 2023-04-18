package com.framework.lib.base.browser;

import com.framework.lib.utils.ConfigFileReader;
import com.framework.lib.utils.PropertyFileManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class BrowserPage {

    private static final String OUTPUT_DIR = "screenshots";

    protected final WebDriver webDriver;
    private String testName;

    // Config
    protected final ConfigFileReader config = PropertyFileManager.getInstance().getConfigReader();


    public BrowserPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public BrowserPage(String testName, final WebDriver driver) throws AWTException {
        this.testName = testName;
        this.webDriver = driver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }


    public void sleepThread(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public void sendValue(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void sendValueUsingAction(String value) {
        new Actions(webDriver)
                .sendKeys(value).keyDown(Keys.ENTER)
                .perform();
    }

    public boolean fluentWait(WebDriver driver, int timeLimitInSeconds, WebElement element) {
        boolean state = false;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            Wait wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(timeLimitInSeconds))
                    .pollingEvery(Duration.ofMillis(50))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(TimeoutException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            state = true;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitlyWait()));
        } catch (Exception ignored) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitlyWait()));
        }
        return state;
    }

    public boolean implicitWait(WebDriver driver, int timeLimitInSeconds, WebElement element) {
        boolean state = false;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeLimitInSeconds));
            state = true;
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitlyWait()));
        } catch (Exception ignored) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitlyWait()));
        }
        return state;
    }


    public void switchToFrame(WebElement frame) {
        webDriver.switchTo().frame(frame);
    }

    public void doubleClick(WebElement element) {
        Actions action = new Actions(webDriver);
        action.doubleClick(element).perform();
    }

    public void keyPressReleaseByRobot(int keyCodeToPress) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCodeToPress);
            robot.keyRelease(keyCodeToPress);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
