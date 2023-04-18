package com.framework.userinterface.web.pom;

import com.framework.lib.base.browser.BrowserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamProjectPage extends BrowserPage implements com.framework.userinterface.web.interfaces.TeamProjectPage {
    WebDriver driver;

    public TeamProjectPage(String testName, WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = LOCATOR.NEW_FIGJAM_FILE)
    private WebElement newFigJamFile;

    @Override
    public void createNewFigJamFile() {
        click(newFigJamFile);
    }
}
