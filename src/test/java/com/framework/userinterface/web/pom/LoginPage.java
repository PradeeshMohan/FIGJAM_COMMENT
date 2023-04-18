package com.framework.userinterface.web.pom;

import com.framework.lib.base.browser.BrowserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserPage implements com.framework.userinterface.web.interfaces.LoginPage {
    WebDriver driver;


//    Locators

    @FindBy(xpath = LOCATOR.LOGIN_BUTTON_TO_OPEN_FORM)
    private WebElement loginButtonToOpenForm;
    @FindBy(xpath = LOCATOR.USERNAME_FIELD)
    private WebElement usernameField;
    @FindBy(xpath = LOCATOR.USER_PASSWORD)
    private WebElement passwordField;
    @FindBy(xpath = LOCATOR.LOGIN_BUTTON)
    private WebElement loginButton;
    @FindBy(xpath = LOCATOR.LOGIN_IFRAME_FORM)
    private WebElement loginIframe;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage(String testName, WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Override
    public void loginIntoTheApp(String username, String userPassword) {
        click(loginButtonToOpenForm);
        if (!fluentWait(driver, 1, usernameField)) {
            switchToFrame(loginIframe);
        }
        sendValue(usernameField, username);
        sendValue(passwordField, userPassword);
        click(loginButton);
        driver.switchTo().parentFrame();
    }


}
