package com.framework.userinterface.web.utils;


import com.framework.lib.base.browser.BrowserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public abstract class BrowserUtil extends BrowserPage {


    public BrowserUtil(WebDriver driver) {
        super(driver);
    }

    public void clickHoldMoveInsideElement(WebElement parentElement, int X, int Y, int X1, int Y1) {
        Actions action = new Actions(webDriver);
        action.moveToElement(parentElement, X, Y).clickAndHold()
                .moveByOffset(X1, Y1).release().perform();
    }

    public void clickInsideElement(WebElement element, int X, int Y) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element, X, Y).click().perform();
    }



}
